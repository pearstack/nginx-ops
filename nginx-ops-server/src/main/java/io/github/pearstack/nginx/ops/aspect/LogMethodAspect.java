package io.github.pearstack.nginx.ops.aspect;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.Header;
import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import io.github.pearstack.nginx.ops.annotation.Log;
import io.github.pearstack.nginx.ops.module.system.pojo.SysLoggingDO;
import io.github.pearstack.nginx.ops.module.system.service.SysLoggingService;
import io.github.pearstack.nginx.ops.util.ip.IpUtils;
import io.github.pearstack.nginx.ops.util.json.JacksonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author lihao3
 * @since 2022/4/25
 */
@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class LogMethodAspect {

  private final SysLoggingService loggingService;

  /** 配置织入点 */
  @Pointcut("@annotation(io.github.pearstack.nginx.ops.annotation.Log)")
  public void logMethodPointCut() {}

  /** 处理完请求后执行 */
  @AfterReturning(pointcut = "logMethodPointCut()", returning = "jsonResult")
  public void doAfterReturning(JoinPoint joinPoint, Object jsonResult) {
    this.handleLog(joinPoint, null, jsonResult);
  }

  /** 拦截异常操作 */
  @AfterThrowing(value = "logMethodPointCut()", throwing = "e")
  public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
    this.handleLog(joinPoint, e, null);
  }

  /**
   * 获取入参
   *
   * @param joinPoint
   * @return
   */
  private Map<String, Object> getRequestParamsByJoinPoint(JoinPoint joinPoint) {
    // 参数名
    String[] paramNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
    // 参数值
    Object[] paramValues = joinPoint.getArgs();
    return this.buildRequestParam(paramNames, paramValues);
  }

  /**
   * 装配参数
   *
   * @param paramNames
   * @param paramValues
   * @return
   */
  private Map<String, Object> buildRequestParam(String[] paramNames, Object[] paramValues) {
    Map<String, Object> requestParams = new HashMap<>(16);
    for (int i = 0; i < paramNames.length; i++) {
      Object value = paramValues[i];
      // 跳过不能获取参数的类
      if (value instanceof ServletRequest || value instanceof ServletResponse) {
        continue;
      } else if (value instanceof MultipartFile) {
        // 如果是文件对象
        MultipartFile file = (MultipartFile) value;
        // 获取文件名
        value = file.getOriginalFilename();
      } else if (value instanceof MultipartFile[]) {
        // 如果是文件对象
        MultipartFile[] files = (MultipartFile[]) value;
        // 获取文件名
        List<String> fileList =
            Arrays.stream(files)
                .map(MultipartFile::getOriginalFilename)
                .collect(Collectors.toList());
        value = String.join(",", fileList);
      }
      requestParams.put(paramNames[i], value);
    }
    return requestParams;
  }

  /**
   * 获取注解
   *
   * @param joinPoint
   * @return
   */
  private Log getAnnotationLog(JoinPoint joinPoint) {
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    Method method = methodSignature.getMethod();
    if (method != null) {
      return method.getAnnotation(Log.class);
    }
    return null;
  }

  /**
   * 核心方法, 整理数据并持久化
   *
   * @param joinPoint
   * @param e
   * @param jsonResult
   */
  private void handleLog(JoinPoint joinPoint, Exception e, Object jsonResult) {
    // 获取请求流
    ServletRequestAttributes attributes =
        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();
    // 获取注解上的参数
    Log annotationLog = this.getAnnotationLog(joinPoint);
    // 获取浏览器信息
    UserAgent userAgent = UserAgentUtil.parse(request.getHeader(Header.USER_AGENT.toString()));
    // 装配参数
    SysLoggingDO sysLoggingDO =
        SysLoggingDO.builder()
            .title(annotationLog.title())
            .method(request.getMethod())
            .businessType(annotationLog.businessType().getCode())
            .requestMethod(
                String.format(
                    "%s.%s",
                    joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName()))
            .operateName("lihao3")
            .operateUrl(String.valueOf(request.getRequestURL()))
            .operateAddress(IpUtils.getIpAddr(request))
            .requestParam(
                annotationLog.isSaveRequestData()
                    ? JacksonUtils.bean2Json(getRequestParamsByJoinPoint(joinPoint))
                    : null)
            .responseBody(
                annotationLog.isSaveResponseData() ? JacksonUtils.bean2Json(jsonResult) : null)
            .success(ObjectUtil.isEmpty(e))
            .browser(userAgent.getBrowser().getName())
            .systemOs(userAgent.getOs().getName())
            .build();
    // 异步持久化数据
    CompletableFuture.runAsync(() -> loggingService.save(sysLoggingDO));
  }
}

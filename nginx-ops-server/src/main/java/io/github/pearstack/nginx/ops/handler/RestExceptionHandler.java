package io.github.pearstack.nginx.ops.handler;

import com.google.common.base.Joiner;
import io.github.pearstack.nginx.ops.exception.BusinessException;
import io.github.pearstack.nginx.ops.pojo.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author lihao3
 * @since 2022/4/25
 */
@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

  /** 自定义异常抛出 */
  @ExceptionHandler(BusinessException.class)
  public R businessExceptionHandler(BusinessException e) {
    return R.error(e.getMessageCode(), e.getDetailMessage());
  }

  /** 请求格式错误 */
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public R businessExceptionHandler(HttpRequestMethodNotSupportedException e) {
    return R.error("错误的请求格式, 请联系IT解决!");
  }

  /** json转换错误 */
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public R httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
    return R.error("接口参数转换异常, 请联系IT解决!");
  }

  /** 自定义验证异常 */
  @ExceptionHandler(BindException.class)
  public R validatedBindException(BindException e) {
    String message = e.getAllErrors().get(0).getDefaultMessage();
    return R.error(message);
  }

  /** 自定义验证异常 */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public R validExceptionHandler(MethodArgumentNotValidException e) {
    String message =
        Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
    return R.error(message);
  }

  /**
   * valid&validate 校验异常
   *
   * @param e
   * @return
   */
  @ExceptionHandler(ConstraintViolationException.class)
  public R constraintViolationExceptionExceptionHandler(ConstraintViolationException e) {
    Set<String> messages = new HashSet<>();
    for (ConstraintViolation<?> error : e.getConstraintViolations()) {
      messages.add(error.getMessage());
    }
    return R.error(Joiner.on(",").skipNulls().join(messages));
  }

  /** 未知异常抛出 */
  @ExceptionHandler(Exception.class)
  public R handleException(Exception e) {
    log.error(e.getMessage(), e);
    return R.error("系统繁忙, 请联系IT解决!");
  }
}

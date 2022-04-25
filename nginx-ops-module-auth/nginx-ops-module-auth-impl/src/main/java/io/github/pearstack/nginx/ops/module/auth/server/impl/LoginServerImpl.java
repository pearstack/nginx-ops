package io.github.pearstack.nginx.ops.module.auth.server.impl;

import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import io.github.pearstack.nginx.ops.exception.BusinessException;
import io.github.pearstack.nginx.ops.module.auth.pojo.dto.LoginDTO;
import io.github.pearstack.nginx.ops.module.auth.pojo.vo.CaptchaVO;
import io.github.pearstack.nginx.ops.module.auth.server.CaptchaServer;
import io.github.pearstack.nginx.ops.module.auth.server.LoginServer;
import io.github.pearstack.nginx.ops.module.system.api.pojo.vo.SysUserVO;
import io.github.pearstack.nginx.ops.module.system.api.service.SysUserApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author lihao3
 * @since 2022/4/25
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LoginServerImpl implements LoginServer {

  private final CaptchaServer captchaServer;
  private final SysUserApiService sysUserApiService;
  private final BCryptPasswordEncoder encoder;

  @Override
  public String pcLogin(LoginDTO loginDTO) {
    // 判断验证码
    if (!captchaServer.isCheck(
        CaptchaVO.builder().key(loginDTO.getVerKey()).image(loginDTO.getVerCode()).build())) {
      throw new BusinessException("验证码不正确!");
    }
    // 获取用户信息
    SysUserVO userVO = sysUserApiService.getOne(loginDTO.getUsername());
    // 判断密码是否正确
    if (ObjectUtil.isEmpty(userVO)
        || !encoder.matches(loginDTO.getPassword(), userVO.getPassword())) {
      throw new BusinessException("账号或密码错误, 请重试!");
    }
    // 执行登录方法
    StpUtil.login(
        loginDTO.getUsername(),
        new SaLoginModel().setDevice("PC").setIsLastingCookie(loginDTO.getRememberMe()));
    // 返回token
    return StpUtil.getTokenValue();
  }
}

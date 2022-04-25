package io.github.pearstack.nginx.ops.module.auth.server;

import io.github.pearstack.nginx.ops.module.auth.pojo.dto.LoginDTO;

/**
 * 登录相关接口
 *
 * @author lihao3
 * @since 2022/4/25
 */
public interface LoginServer {

  /**
   * 登录接口
   *
   * @param loginDTO
   * @return token
   */
  String pcLogin(LoginDTO loginDTO);
}

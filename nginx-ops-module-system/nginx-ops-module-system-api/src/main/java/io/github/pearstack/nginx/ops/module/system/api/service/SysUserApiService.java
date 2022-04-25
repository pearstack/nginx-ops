package io.github.pearstack.nginx.ops.module.system.api.service;

import io.github.pearstack.nginx.ops.module.system.api.pojo.vo.SysUserVO;

/**
 * @author lihao3
 * @since 2022/4/25
 */
public interface SysUserApiService {

  /**
   * 根据登录名查询用户信息
   *
   * @param username
   * @return
   */
  SysUserVO getOne(String username);
}

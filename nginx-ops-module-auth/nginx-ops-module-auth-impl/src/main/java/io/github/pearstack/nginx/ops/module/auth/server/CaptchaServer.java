package io.github.pearstack.nginx.ops.module.auth.server;

import io.github.pearstack.nginx.ops.module.auth.pojo.vo.CaptchaVO;

/**
 * 验证码相关接口
 *
 * @author lihao3
 * @since 2022/4/25
 */
public interface CaptchaServer {

  /**
   * 生成验证码
   *
   * @return
   */
  CaptchaVO generateCaptcha();

  /**
   * 验证验证码是否有效
   *
   * @param captchaVO
   * @return
   */
  boolean isCheck(CaptchaVO captchaVO);
}

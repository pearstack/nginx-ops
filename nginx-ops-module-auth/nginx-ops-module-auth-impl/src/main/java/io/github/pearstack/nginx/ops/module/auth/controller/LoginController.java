package io.github.pearstack.nginx.ops.module.auth.controller;

import io.github.pearstack.nginx.ops.module.auth.pojo.dto.LoginDTO;
import io.github.pearstack.nginx.ops.module.auth.pojo.vo.CaptchaVO;
import io.github.pearstack.nginx.ops.module.auth.server.CaptchaServer;
import io.github.pearstack.nginx.ops.module.auth.server.LoginServer;
import io.github.pearstack.nginx.ops.pojo.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author lihao3
 * @since 2022/4/25
 */
@Api(tags = "鉴权接口")
@Slf4j
@RestController
@RequestMapping
@RequiredArgsConstructor
public class LoginController {

  private final CaptchaServer captchaServer;
  private final LoginServer loginServer;

  @ApiOperation("生成验证码")
  @GetMapping("/captcha")
  public R<CaptchaVO> captcha() {
    CaptchaVO captchaVO = captchaServer.generateCaptcha();
    return R.success("生成成功!", captchaVO);
  }

  @ApiOperation("登录")
  @PostMapping("/pc/login")
  public R<String> login(@RequestBody LoginDTO loginDTO) {
    String token = loginServer.pcLogin(loginDTO);
    return R.success("登录成功!", token);
  }
}

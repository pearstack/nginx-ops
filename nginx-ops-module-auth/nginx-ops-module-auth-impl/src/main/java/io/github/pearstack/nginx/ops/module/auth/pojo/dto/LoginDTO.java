package io.github.pearstack.nginx.ops.module.auth.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lihao3
 * @since 2022/4/25
 */
@Data
@ApiModel("登录表单实体类")
public class LoginDTO {

  /** 登录名 */
  @ApiModelProperty("登录名")
  private String username;
  /** 密码 */
  @ApiModelProperty("密码")
  private String password;
  /** 验证码内容 */
  @ApiModelProperty("验证码内容")
  private String verCode;
  /** 验证码key */
  @ApiModelProperty("验证码key")
  private String verKey;
  /** 是否记住密码 */
  @ApiModelProperty("是否记住密码")
  private Boolean rememberMe;
}

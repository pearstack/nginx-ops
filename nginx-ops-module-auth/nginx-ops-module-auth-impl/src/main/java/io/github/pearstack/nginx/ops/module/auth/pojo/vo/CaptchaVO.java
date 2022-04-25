package io.github.pearstack.nginx.ops.module.auth.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

/**
 * @author lihao3
 * @since 2022/4/25
 */
@Getter
@Builder
@ToString
@ApiModel("生成验证码返回实体类")
public class CaptchaVO {

  /** 验证码的key */
  @ApiModelProperty("验证码的key")
  private String key;

  /** 验证码的base64位 */
  @ApiModelProperty("验证码的base64位")
  private String image;
}

package io.github.pearstack.nginx.ops.module.system.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author lihao3
 * @since 2022/4/25
 */
@Getter
@Builder
@ToString
@ApiModel("服务器相关信息")
public class Sys {

  /** 服务器名称 */
  @ApiModelProperty("服务器名称")
  private String computerName;
  /** 服务器Ip */
  @ApiModelProperty("服务器Ip")
  private String computerIp;
  /** 项目路径 */
  @ApiModelProperty("项目路径")
  private String userDir;
  /** 操作系统 */
  @ApiModelProperty("操作系统")
  private String osName;
  /** 系统架构 */
  @ApiModelProperty("系统架构")
  private String osArch;
}

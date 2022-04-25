package io.github.pearstack.nginx.ops.module.system.pojo.vo;

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
public class Sys {

  /** 服务器名称 */
  private String computerName;
  /** 服务器Ip */
  private String computerIp;
  /** 项目路径 */
  private String userDir;
  /** 操作系统 */
  private String osName;
  /** 系统架构 */
  private String osArch;
}

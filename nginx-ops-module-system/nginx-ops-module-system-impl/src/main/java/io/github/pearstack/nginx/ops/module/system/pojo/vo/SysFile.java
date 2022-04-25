package io.github.pearstack.nginx.ops.module.system.pojo.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author lihao3
 * @since 2022/4/25
 */
@Getter
@Builder
@ToString
public class SysFile {

  /** 盘符路径 */
  private String dirName;

  /** 文件类型 */
  private String typeName;

  /** 总大小 */
  private long total;

  /** 剩余大小 */
  private long free;

  /** 已经使用量 */
  private long used;

  /** 资源的使用率 */
  private long usage;
}

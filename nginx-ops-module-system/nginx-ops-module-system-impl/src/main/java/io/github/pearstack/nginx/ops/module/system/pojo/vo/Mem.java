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
public class Mem {

  /** 内存总量 */
  private long total;

  /** 已用内存 */
  private long used;

  /** 剩余内存 */
  private long free;
}

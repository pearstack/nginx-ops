package io.github.pearstack.nginx.ops.module.system.pojo.vo;

import cn.hutool.core.io.unit.DataSizeUtil;
import io.swagger.annotations.ApiModelProperty;
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
public class Jvm {

  /** 当前JVM占用的内存总数(M) */
  @ApiModelProperty("当前JVM占用的内存总数(M)")
  private Long total;
  /** JVM最大可用内存总数(M) */
  @ApiModelProperty("JVM最大可用内存总数(M)")
  private Long max;
  /** JVM空闲内存(M) */
  @ApiModelProperty("JVM空闲内存(M)")
  private Long free;
  /** JDK版本 */
  @ApiModelProperty("JDK版本")
  private String version;
  /** JDK路径 */
  @ApiModelProperty("JDK路径")
  private String home;

  public String getTotal() {
    return DataSizeUtil.format(total);
  }

  public String getMax() {
    return DataSizeUtil.format(max);
  }

  public String getFree() {
    return DataSizeUtil.format(free);
  }
}

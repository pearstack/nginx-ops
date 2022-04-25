package io.github.pearstack.nginx.ops.module.system.pojo.vo;

import cn.hutool.core.io.unit.DataSizeUtil;
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
@ApiModel
public class Mem {

  /** 内存总量 */
  @ApiModelProperty("内存总量")
  private long total;
  /** 已用内存 */
  @ApiModelProperty("已用内存")
  private long used;
  /** 剩余内存 */
  @ApiModelProperty("剩余内存")
  private long free;

  public String getTotal() {
    return DataSizeUtil.format(total);
  }

  public String getUsed() {
    return DataSizeUtil.format(used);
  }

  public String getFree() {
    return DataSizeUtil.format(free);
  }
}

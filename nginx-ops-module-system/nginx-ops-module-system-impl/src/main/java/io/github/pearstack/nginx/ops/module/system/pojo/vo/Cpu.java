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
@ApiModel("CPU信息")
public class Cpu {

  /** CPU核心数 */
  @ApiModelProperty("CPU核心数")
  private Integer cpuNum;
  /** CPU总的使用率 */
  @ApiModelProperty("CPU总的使用率")
  private double total;
  /** CPU系统使用率 */
  @ApiModelProperty("CPU系统使用率")
  private double sys;
  /** CPU用户使用率 */
  @ApiModelProperty("CPU用户使用率")
  private double user;
  /** CPU当前等待率 */
  @ApiModelProperty("CPU当前等待率")
  private double wait;
  /** CPU当前空闲率 */
  @ApiModelProperty("CPU当前空闲率")
  private double free;
}

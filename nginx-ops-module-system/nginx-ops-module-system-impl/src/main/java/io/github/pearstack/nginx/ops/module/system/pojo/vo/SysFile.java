package io.github.pearstack.nginx.ops.module.system.pojo.vo;

import cn.hutool.core.io.unit.DataSizeUtil;
import io.swagger.annotations.ApiModel;
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
@ApiModel("磁盘相关信息")
public class SysFile {

  /** 盘符路径 */
  @ApiModelProperty("盘符路径")
  private String dirName;
  /** 文件类型 */
  @ApiModelProperty("文件类型")
  private String typeName;
  /** 总大小 */
  @ApiModelProperty("总大小")
  private long total;
  /** 剩余大小 */
  @ApiModelProperty("剩余大小")
  private long free;
  /** 已经使用量 */
  @ApiModelProperty("已经使用量")
  private long used;
  /** 资源的使用率 */
  @ApiModelProperty("资源的使用率")
  private double usage;

  public String getTotal() {
    return DataSizeUtil.format(total);
  }

  public String getFree() {
    return DataSizeUtil.format(free);
  }

  public String getUsed() {
    return DataSizeUtil.format(used);
  }
}

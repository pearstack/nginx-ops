package io.github.pearstack.nginx.ops.pojo.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lihao3
 * @since 2022/4/25
 */
@Data
@ApiModel("通用查询实体类")
public class BaseQuery implements Serializable {

  /** 登录人名称 */
  @ApiModelProperty("登录人名称")
  private String username;
  /** 页码 */
  @ApiModelProperty("页码")
  private Integer pageNum = 1;
  /** 页数 */
  @ApiModelProperty("页数")
  private Integer pageSize = 20;
  /** 排序 */
  @ApiModelProperty("排序")
  private String orderBy;
}

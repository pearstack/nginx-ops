package io.github.pearstack.nginx.ops.module.system.pojo.query;

import io.github.pearstack.nginx.ops.pojo.query.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lihao3
 * @since 2022/4/25
 */
@Data
@ApiModel("用户列表搜索实体类")
@EqualsAndHashCode(callSuper = true)
public class SysUserQuery extends BaseQuery {

  /** 账户 */
  @ApiModelProperty("用户名")
  private String username;
  /** 姓名 */
  @ApiModelProperty("姓名")
  private String realName;
  /** 邮箱 */
  @ApiModelProperty("邮箱")
  private String email;
  /** 性别 */
  @ApiModelProperty("性别")
  private String sex;
  /** 电话 */
  @ApiModelProperty("电话")
  private String phone;
  /** 是否启用 */
  @ApiModelProperty("是否启用")
  private Boolean enable;
  /** 是否登录 */
  @ApiModelProperty("是否登录")
  private Boolean login;
  /** 起始最后一次登录时间 */
  @ApiModelProperty("起始最后一次登录时间")
  private String startLastTime;
  /** 终止最后一次登录时间 */
  @ApiModelProperty("终止最后一次登录时间")
  private String endLastTime;
}

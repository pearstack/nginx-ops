package io.github.pearstack.nginx.ops.module.system.api.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName sys_user
 */
@Data
public class SysUserVO implements Serializable {

  /** 编号 */
  private String userId;

  /** 账户 */
  private String username;

  /** 密码 */
  private String password;

  /** 姓名 */
  private String salt;

  /** 状态 */
  private String status;

  /** 姓名 */
  private String realName;

  /** 邮箱 */
  private String email;

  /** 头像 */
  private String avatar;

  /** 性别 */
  private String sex;

  /** 电话 */
  private String phone;

  /** 创建时间 */
  private Date createTime;

  /** 创建人 */
  private String createBy;

  /** 修改时间 */
  private Date updateTime;

  /** 修改人 */
  private String updateBy;

  /** 备注 */
  private String remark;

  /** 是否启用 */
  private Boolean enable;

  /** 是否登录 */
  private Boolean login;

  /** 最后一次登录时间 */
  private Date lastTime;

  private static final long serialVersionUID = 1L;
}

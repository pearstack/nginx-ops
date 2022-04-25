package io.github.pearstack.nginx.ops.module.system.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName sys_user
 */
@TableName(value = "sys_user")
@Data
public class SysUserDO implements Serializable {

  /** 编号 */
  @TableId private String userId;

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

  @TableField(exist = false)
  private static final long serialVersionUID = 1L;
}

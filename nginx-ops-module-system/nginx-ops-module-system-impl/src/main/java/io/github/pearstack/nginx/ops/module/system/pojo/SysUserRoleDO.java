package io.github.pearstack.nginx.ops.module.system.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName sys_user_role
 */
@TableName(value = "sys_user_role")
@Data
public class SysUserRoleDO implements Serializable {

  /** 标识 */
  @TableId private String id;

  /** 用户编号 */
  private String userId;

  /** 角色编号 */
  private String roleId;

  @TableField(exist = false)
  private static final long serialVersionUID = 1L;
}

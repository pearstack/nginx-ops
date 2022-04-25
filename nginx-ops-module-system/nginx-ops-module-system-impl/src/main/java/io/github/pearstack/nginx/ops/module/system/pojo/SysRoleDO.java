package io.github.pearstack.nginx.ops.module.system.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName sys_role
 */
@TableName(value = "sys_role")
@Data
public class SysRoleDO implements Serializable {

  /** 角色编号 */
  @TableId private String roleId;

  /** 角色名称 */
  private String roleName;

  /** 角色标识 */
  private String roleCode;

  /** 是否启用 */
  private String enable;

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

  /** 详情 */
  private String details;

  /** 排序 */
  private Integer sort;

  @TableField(exist = false)
  private static final long serialVersionUID = 1L;
}

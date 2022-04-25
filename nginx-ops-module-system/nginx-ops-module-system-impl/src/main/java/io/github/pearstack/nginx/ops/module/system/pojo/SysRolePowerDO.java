package io.github.pearstack.nginx.ops.module.system.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName sys_role_power
 */
@TableName(value = "sys_role_power")
@Data
public class SysRolePowerDO implements Serializable {

  /** */
  @TableId private String id;

  /** */
  private String roleId;

  /** */
  private String powerId;

  /** */
  private String createBy;

  /** */
  private Date createTime;

  /** */
  private String updateBy;

  /** */
  private Date updateTime;

  /** */
  private String remark;

  @TableField(exist = false)
  private static final long serialVersionUID = 1L;
}

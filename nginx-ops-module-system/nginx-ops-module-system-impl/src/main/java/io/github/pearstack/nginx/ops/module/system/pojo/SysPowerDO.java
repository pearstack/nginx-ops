package io.github.pearstack.nginx.ops.module.system.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName sys_power
 */
@TableName(value = "sys_power")
@Data
public class SysPowerDO implements Serializable {

  /** 权限编号 */
  @TableId private String powerId;

  /** 权限名称 */
  private String powerName;

  /** 权限类型 */
  private String powerType;

  /** 权限标识 */
  private String powerCode;

  /** 权限路径 */
  private String powerUrl;

  /** 打开方式 */
  private String openType;

  /** 父类编号 */
  private String parentId;

  /** 图标 */
  private String icon;

  /** 排序 */
  private Integer sort;

  /** 创建人 */
  private String createBy;

  /** 创建时间 */
  private Date createTime;

  /** 修改人 */
  private String updateBy;

  /** 修改时间 */
  private Date updateTime;

  /** 备注 */
  private String remark;

  /** 是否开启 */
  private String enable;

  @TableField(exist = false)
  private static final long serialVersionUID = 1L;
}

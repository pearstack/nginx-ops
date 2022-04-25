package io.github.pearstack.nginx.ops.module.system.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName sys_file
 */
@TableName(value = "sys_file")
@Data
public class SysFileDO implements Serializable {

  /** 标识 */
  @TableId private String id;

  /** 文件名称 */
  private String fileName;

  /** 文件描述 */
  private String fileDesc;

  /** 文件路径 */
  private String filePath;

  /** 文件类型 */
  private String fileType;

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

  /** 所属时间 */
  private Date targetDate;

  /** 文件大小 */
  private String fileSize;

  @TableField(exist = false)
  private static final long serialVersionUID = 1L;
}

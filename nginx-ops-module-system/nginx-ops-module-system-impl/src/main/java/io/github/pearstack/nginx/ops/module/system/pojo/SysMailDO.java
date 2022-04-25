package io.github.pearstack.nginx.ops.module.system.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName sys_mail
 */
@TableName(value = "sys_mail")
@Data
public class SysMailDO implements Serializable {

  /** 邮件id(主键) */
  @TableId private String mailId;

  /** 收件人邮箱 */
  private String receiver;

  /** 邮件主体 */
  private String subject;

  /** 邮件正文 */
  private String content;

  /** 发送人 */
  private String createBy;

  /** 创建时间 */
  private Date createTime;

  @TableField(exist = false)
  private static final long serialVersionUID = 1L;
}

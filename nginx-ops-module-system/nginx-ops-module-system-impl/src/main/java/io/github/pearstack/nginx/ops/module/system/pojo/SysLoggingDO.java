package io.github.pearstack.nginx.ops.module.system.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName sys_logging
 */
@TableName(value = "sys_logging")
@Data
public class SysLoggingDO implements Serializable {

  /** 相应消息体 */
  @TableId private String id;

  /** 标题 */
  private String title;

  /** 请求方式 */
  private String method;

  /** 业务类型 */
  private String businessType;

  /** 请求方法 */
  private String requestMethod;

  /** 操作人 */
  private String operateName;

  /** 操作路径 */
  private String operateUrl;

  /** 操作地址 */
  private String operateAddress;

  /** 请求参数 */
  private String requestParam;

  /** 相应消息体 */
  private String responseBody;

  /** 是否成功 */
  private String success;

  /** 异常信息 */
  private String errorMsg;

  /** 创建时间 */
  private Date createTime;

  /** 描述 */
  private String description;

  /** 请求消息体 */
  private String requestBody;

  /** 使用浏览器 */
  private String browser;

  /** 操作系统 */
  private String systemOs;

  /** 日志类型，登录日志，操作日志 */
  private String loggingType;

  @TableField(exist = false)
  private static final long serialVersionUID = 1L;
}

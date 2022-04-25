package io.github.pearstack.nginx.ops.exception;

import io.github.pearstack.nginx.ops.constants.ReturnCodeConstant;
import lombok.Getter;

/**
 * 业务异常
 *
 * @author lihao3
 * @since 2022/4/25
 */
@Getter
public class BusinessException extends RuntimeException {

  /** 异常编号 */
  private final String messageCode;
  /** 对messageCode 异常信息进行补充说明 */
  private final String detailMessage;

  /**
   * 构造函数 默认失败code
   *
   * @param msg
   */
  public BusinessException(String msg) {
    this(ReturnCodeConstant.ERROR, msg);
  }

  /**
   * 有参构造
   *
   * @param messageCode
   * @param message
   */
  public BusinessException(String messageCode, String message) {
    super(message);
    this.messageCode = messageCode;
    this.detailMessage = message;
  }
}

package io.github.pearstack.nginx.ops;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lihao3
 * @since 2022/4/25
 */
@Data
public class R<T> implements Serializable {

  /** 编码 */
  private String code;
  /** 内容 */
  private String msg;
  /** 请求时间 */
  private long time;
  /** 返回内容 */
  private T data;
  /** 总条数 */
  private int count;

}

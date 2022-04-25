package io.github.pearstack.nginx.ops.pojo.vo;

import com.github.pagehelper.Page;
import io.github.pearstack.nginx.ops.constants.ReturnCodeConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lihao3
 * @since 2022/4/25
 */
@Data
@ApiModel("通用返回实体类")
public class R<T> implements Serializable {

  /** 编码 */
  @ApiModelProperty("返回编码(200代表成功)")
  private String code;
  /** 内容 */
  @ApiModelProperty("提示内容")
  private String msg;
  /** 反馈时间 */
  @ApiModelProperty("反馈时间")
  private long time;
  /** 返回数据 */
  @ApiModelProperty("返回数据")
  private T data;
  /** 总条数 */
  @ApiModelProperty("总条数")
  private long count;

  public static <T> R<T> success(String msg, T data) {
    R<T> r = new R<>();
    r.setCode(ReturnCodeConstant.SUCCESS);
    r.setMsg(msg);
    r.setTime(System.currentTimeMillis());
    r.setData(data);
    r.setCount(1L);
    return r;
  }

  public static <T> R<T> success(String msg, Page<T> data) {
    R<T> r = new R<>();
    r.setCode(ReturnCodeConstant.SUCCESS);
    r.setMsg(msg);
    r.setTime(System.currentTimeMillis());
    r.setData((T) data.getResult());
    r.setCount(data.getTotal());
    return r;
  }

  public static <T> R<T> error(String code, String msg) {
    R<T> r = new R<>();
    r.setCode(code);
    r.setMsg(msg);
    r.setTime(System.currentTimeMillis());
    return r;
  }

  public static <T> R<T> error(String msg) {
    R<T> r = new R<>();
    r.setCode(ReturnCodeConstant.ERROR);
    r.setMsg(msg);
    r.setTime(System.currentTimeMillis());
    return r;
  }
}

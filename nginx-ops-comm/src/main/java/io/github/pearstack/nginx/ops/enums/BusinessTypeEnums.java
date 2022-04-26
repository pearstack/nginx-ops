package io.github.pearstack.nginx.ops.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lihao3
 * @since 2022/4/25
 */
@Getter
@AllArgsConstructor
public enum BusinessTypeEnums {
  SELECT("select", "查询"),
  INSERT("insert", "插入"),
  UPDATE("update", "更新"),
  DELETE("delete", "删除"),
  OTHER("other", "其他"),
  ;

  /** 编码 */
  private final String code;
  /** 描述 */
  private final String desc;
}

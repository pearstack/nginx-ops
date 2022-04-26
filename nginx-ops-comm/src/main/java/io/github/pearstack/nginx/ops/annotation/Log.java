package io.github.pearstack.nginx.ops.annotation;

import io.github.pearstack.nginx.ops.enums.BusinessTypeEnums;

/**
 * @author lihao3
 * @since 2022/4/25
 */
public @interface Log {

  /** 记录标题 */
  String title() default "";

  /** 操作类别 */
  BusinessTypeEnums businessType() default BusinessTypeEnums.OTHER;

  /** 是否保存请求参数 */
  boolean isSaveRequestData() default true;

  /** 是否保存返回参数 */
  boolean isSaveResponseData() default true;
}

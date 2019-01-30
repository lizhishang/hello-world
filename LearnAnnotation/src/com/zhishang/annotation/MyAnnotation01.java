package com.zhishang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation01 {

    //注解的参数
    String testString() default "";
    int testInt() default 0;
    //表示-1大多数表示不存在
    int testId() default -1;
    String[] testArray() default {"111", "222"};
}

package com.zhishang.annotation;

/**
 * Test MyAnnotation01
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 19:33 2019-01-29
 */
//单属性value可以简单省略
@MyAnnotation02(value = "aaa")
public class Demo02 {

    @MyAnnotation02("bbb")
    public void test1(){}
}

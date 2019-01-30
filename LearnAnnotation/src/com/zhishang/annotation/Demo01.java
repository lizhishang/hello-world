package com.zhishang.annotation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * some annotations
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 18:50 2019-01-29
 */
public class Demo01 {

    //Override.class
    @Override
    public String toString() {
        return "";
    }

//    被遗弃方法 不推荐使用
    @Deprecated
    private static void test1() {
        System.out.println("test");
    }

//    抑制警告信息
    @SuppressWarnings("all")
    private static void test2() {
        StringBuilder builder = new StringBuilder("4444");
    }

    public static void main(String[] args) {
        test1();
    }
}

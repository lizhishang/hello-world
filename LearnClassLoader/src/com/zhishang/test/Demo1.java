package com.zhishang.test;

/**
 * Test FileSystemClassLoader
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 17:15 2019-01-30
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {
        FileSystemClassLoader loader = new FileSystemClassLoader("/Users/zhishangli/Desktop");
        FileSystemClassLoader loader2 = new FileSystemClassLoader("/Users/zhishangli/Desktop");

        Class clazz1 = loader.loadClass("Test");
        Class clazz2 = loader.loadClass("Test");
        Class clazz3 = loader2.loadClass("Test");

        System.out.println(clazz1.hashCode());
        System.out.println(clazz2.hashCode());
        System.out.println(clazz3.hashCode());
    }
}

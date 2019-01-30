package com.zhishang.test;

/**
 * 简单的加密与解密（取反）
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:28 2019-01-30
 */
public class Demo2 {
    public static void main(String[] args) throws ClassNotFoundException {
        //简单取反
        int a = 3;
        System.out.println(Integer.toBinaryString(a^0xff));

        //测试读取加密后的class
//        FileSystemClassLoader loader = new FileSystemClassLoader("/Users/zhishangli/Desktop/temp");
//        Class c = loader.findClass("Test");
//        System.out.println(c);

        //解密加密后的class
        DecryptUtil util = new DecryptUtil("/Users/zhishangli/Desktop/temp");
        Class c = util.findClass("Test");
        System.out.println(c);
    }
}

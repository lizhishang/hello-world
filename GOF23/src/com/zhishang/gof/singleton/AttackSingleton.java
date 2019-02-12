package com.zhishang.gof.singleton;

import java.io.*;

/**
 * 利用反射和反序列化破解单例模式（枚举式单例除外）
 * V01 可利用反射破解
 * V01_1 利用抛出异常处理反射破解
 * @author zhishangli
 * @project_name hello-world
 * @time 13:49 2019-01-31
 */
public class AttackSingleton {
    public static void main(String[] args) throws Exception {
        SingletonDemo01_1 demo01 = SingletonDemo01_1.getInstance();
        SingletonDemo01_1 demo02 = SingletonDemo01_1.getInstance();
        //demo1 == demo2
        System.out.println(demo01);
        System.out.println(demo02);

        /*//反射单例模式的类
        Class c = Class.forName("com.zhishang.GOF23.singleton.SingletonDemo01");
        Constructor constructor = c.getDeclaredConstructor(null);
        //跳过安全检查 使private修饰符 失效
        constructor.setAccessible(true);
        SingletonDemo01_1 demo03 = (SingletonDemo01_1) constructor.newInstance();
        SingletonDemo01_1 demo04 = (SingletonDemo01_1) constructor.newInstance();

        //单例模式失效
        System.out.println(demo03);
        System.out.println(demo04);*/

        //利用反序列化的方式构建多个对象
        FileOutputStream out = new FileOutputStream("/Users/zhishangli/Desktop/demoTest.txt");
        ObjectOutputStream outs = new ObjectOutputStream(out);
        outs.writeObject(demo01);
        outs.close();
        out.close();

        FileInputStream in = new FileInputStream("/Users/zhishangli/Desktop/demoTest.txt");
        ObjectInputStream ins = new ObjectInputStream(in);
        SingletonDemo01_1 demo03 = (SingletonDemo01_1) ins.readObject();
        System.out.println(demo03);
    }
}

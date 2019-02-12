package com.zhishang.gof.singleton;

import java.io.Serializable;

/**
 * 饿汉式单例模式
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 12:50 2019-01-31
 */
public class SingletonDemo01 implements Serializable {
    //类加载时，立即加载对象
    private static SingletonDemo01 instance = new SingletonDemo01();

    private SingletonDemo01() {}

    //方法没有同步，调用效率高
    public static SingletonDemo01 getInstance() {
        return instance;
    }
}

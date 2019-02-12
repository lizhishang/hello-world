package com.zhishang.gof.singleton;

/**
 * 懒汉式单例模式
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 12:56 2019-01-31
 */
public class SingletonDemo02 {
    //类初始化时该对象不初始化（等到调用时再加载）
    private static SingletonDemo02 instance;

    private SingletonDemo02() {
    }

    //方法同步，调用效率低
    public static synchronized SingletonDemo02 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo02();
        }
        return instance;
    }
}

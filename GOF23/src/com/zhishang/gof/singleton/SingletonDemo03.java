package com.zhishang.gof.singleton;

/**
 * 双重检测锁式单例模式
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 13:07 2019-01-31
 */
public class SingletonDemo03 {
    private static volatile SingletonDemo03 instance;

    private SingletonDemo03() {}

    public static SingletonDemo03 getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo03.class) {
                if (instance == null) {
                    instance = new SingletonDemo03();
                }
            }
        }
        return instance;
    }
}

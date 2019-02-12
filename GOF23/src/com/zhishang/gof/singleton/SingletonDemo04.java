package com.zhishang.gof.singleton;

/**
 * 静态内部类式单例模式
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 13:07 2019-01-31
 */
public class SingletonDemo04 {
    //静态内部类中生成静态对象
    private static class SingletonClassInstance {
        private final static SingletonDemo04 instance = new SingletonDemo04();
    }

    public static SingletonDemo04 getInstance() {
        return SingletonClassInstance.instance;
    }

    private SingletonDemo04() {
    }
}

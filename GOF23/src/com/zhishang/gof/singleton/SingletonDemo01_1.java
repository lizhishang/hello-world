package com.zhishang.gof.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 饿汉式单例模式 V01_1(防止反射和反序列化漏洞)
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 12:50 2019-01-31
 */
public class SingletonDemo01_1 implements Serializable {
    //类加载时，立即加载对象
    private static SingletonDemo01_1 instance = new SingletonDemo01_1();

    private SingletonDemo01_1() {
        if (instance != null) {
            throw new RuntimeException();
        }
    }

    //方法没有同步，调用效率高
    public static SingletonDemo01_1 getInstance() {
        return instance;
    }

    //反序列化时，如果定义了readResolve()则直接返回此方法指定的对象。而不需要单独再创建新对象
    private Object readResolve() throws ObjectStreamException {
        return instance;
    }
}

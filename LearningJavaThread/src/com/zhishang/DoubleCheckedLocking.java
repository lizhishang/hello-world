package com.zhishang;

/*
 * Singleton lazy model
 * private constructor
 * a public static method to get a instance
 * @project_name    hello-world
 * @author          zhishangli
 * @time            20:37 2019-01-27
 */
public class DoubleCheckedLocking {
    private static DoubleCheckedLocking instance;

    private DoubleCheckedLocking(){}

    public static DoubleCheckedLocking getInstance() {
        //Double check
        if (null != instance) return instance;
        synchronized (DoubleCheckedLocking.class) {
            if (null == instance) {
                instance = new DoubleCheckedLocking();
            }
            return instance;
        }
    }
}

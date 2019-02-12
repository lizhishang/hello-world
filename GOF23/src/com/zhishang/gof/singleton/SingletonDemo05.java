package com.zhishang.gof.singleton;

/**
 * 枚举实现单例模式(没有延时加载)
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 13:07 2019-01-31
 */
public enum SingletonDemo05 {

    //枚举元素本身就是一个单例
    INSTANCE;

    //添加自己需要的操作
    public void singletonOperate(){}
}

package com.zhishang.gof.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 15:54 2019-02-02
 */
public class Client {
    public static void main(String[] args) {
        Star realStar = new RealStar();
        StarHandler handler = new StarHandler(realStar);
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, handler);
        proxy.confer();
        proxy.signContract();
        proxy.bookTicket();
        proxy.sing();
        proxy.collectMoney();
    }
}

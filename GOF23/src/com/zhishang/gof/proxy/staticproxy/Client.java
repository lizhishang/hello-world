package com.zhishang.gof.proxy.staticproxy;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 15:39 2019-02-02
 */
public class Client {
    public static void main(String[] args) {
        Star real = new RealStar();
        Star proxy = new ProxyStar(real);
        proxy.confer();
        proxy.signContract();
        proxy.bookTicket();
        proxy.sing();
        proxy.collectMoney();
    }
}

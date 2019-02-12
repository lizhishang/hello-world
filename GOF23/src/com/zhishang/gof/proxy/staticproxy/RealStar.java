package com.zhishang.gof.proxy.staticproxy;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 15:33 2019-02-02
 */
public class RealStar implements Star {
    @Override
    public void confer() {
        System.out.println("confer");
    }

    @Override
    public void signContract() {
        System.out.println("signContract");
    }

    @Override
    public void bookTicket() {
        System.out.println("bookTicket");
    }

    @Override
    public void sing() {
        System.out.println("star sing");
    }

    @Override
    public void collectMoney() {
        System.out.println("collectMoney");
    }
}

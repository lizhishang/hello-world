package com.zhishang.gof.proxy.staticproxy;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 15:37 2019-02-02
 */
public class ProxyStar implements Star {
    private Star star;

    public ProxyStar(Star star) {
        this.star = star;
    }

    @Override
    public void confer() {
        System.out.println("proxy confer");
    }

    @Override
    public void signContract() {
        System.out.println("proxy signContract");
    }

    @Override
    public void bookTicket() {
        System.out.println("proxy bookTicket");
    }

    @Override
    public void sing() {
        star.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("proxy collectMoney");
    }
}

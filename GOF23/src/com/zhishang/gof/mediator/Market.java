package com.zhishang.gof.mediator;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 23:35 2019-02-10
 */
public class Market implements Department{

    private Mediator mediator;

    public Market(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("market", this);
    }

    @Override
    public void selfAction() {
        System.out.println("market is not enough money");
        mediator.command("finance");
    }

    @Override
    public void outAction() {
        System.out.println("market report to mediator");
    }
}

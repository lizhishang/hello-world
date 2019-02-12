package com.zhishang.gof.mediator;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 23:35 2019-02-10
 */
public class Finance implements Department{

    private Mediator mediator;

    public Finance(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("finance", this);
    }

    @Override
    public void selfAction() {
        System.out.println("finance");
    }

    @Override
    public void outAction() {
        System.out.println("transfer");
    }
}

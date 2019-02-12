package com.zhishang.gof.mediator;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 23:35 2019-02-10
 */
public class Development implements Department{

    private Mediator mediator;

    public Development(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("development", this);
    }

    @Override
    public void selfAction() {
        System.out.println("develop");
    }

    @Override
    public void outAction() {
        System.out.println("development report to mediator");
    }
}

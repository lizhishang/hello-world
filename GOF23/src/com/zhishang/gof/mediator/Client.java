package com.zhishang.gof.mediator;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 23:44 2019-02-10
 */
public class Client {
    public static void main(String[] args) {
        Mediator mediator = new President();

        Department d = new Development(mediator);
        Department m = new Market(mediator);
        Department f = new Finance(mediator);

        m.selfAction();
    }
}

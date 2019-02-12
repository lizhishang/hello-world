package com.zhishang.gof.strategy;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 07:45 2019-02-11
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context(new OldCustomerFewStrategy());
        context.getPrice(1000);
    }
}

package com.zhishang.gof.strategy;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 07:42 2019-02-11
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void getPrice(double price) {
        System.out.println("Price " + strategy.getPrice(price));
    }
}

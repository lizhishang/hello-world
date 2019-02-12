package com.zhishang.gof.factory.abstractfactory;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:39 2019-02-01
 */
public interface Engine {
    void run();
    void start();
}
class LuxuryEngine implements Engine{
    @Override
    public void run() {
        System.out.println("luxury Engine run");
    }

    @Override
    public void start() {
        System.out.println("luxury Engine start");
    }
}
class LowEngine implements Engine{
    @Override
    public void run() {
        System.out.println("low Engine run");
    }

    @Override
    public void start() {
        System.out.println("low Engine start");
    }
}
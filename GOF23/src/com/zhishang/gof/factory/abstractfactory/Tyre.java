package com.zhishang.gof.factory.abstractfactory;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:42 2019-02-01
 */
public interface Tyre {
    void revolve();
}
class LuxuryTyre implements Tyre {
    @Override
    public void revolve() {
        System.out.println("luxury tyre");
    }
}
class LowTyre implements Tyre {
    @Override
    public void revolve() {
        System.out.println("low tyre");
    }
}
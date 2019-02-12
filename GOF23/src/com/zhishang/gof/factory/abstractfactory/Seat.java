package com.zhishang.gof.factory.abstractfactory;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:41 2019-02-01
 */
public interface Seat {
    void massage();
}
class LuxurySeat implements Seat {
    @Override
    public void massage() {
        System.out.println("luxury seat");
    }
}
class LowSeat implements Seat {
    @Override
    public void massage() {
        System.out.println("low seat");
    }
}

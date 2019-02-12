package com.zhishang.gof.factory.abstractfactory;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:47 2019-02-01
 */
public class Test {
    public static void main(String[] args) {
        Engine engine = new LuxuryCarFactory().createEngine();
        Seat seat = new LuxuryCarFactory().createSeat();
        Tyre tyre = new LuxuryCarFactory().createTyre();
    }
}

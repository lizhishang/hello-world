package com.zhishang.gof.factory.abstractfactory;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:45 2019-02-01
 */
public class LuxuryCarFactory implements CarFactory {
    @Override
    public Engine createEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Seat createSeat() {
        return new LuxurySeat();
    }

    @Override
    public Tyre createTyre() {
        return new LuxuryTyre();
    }
}

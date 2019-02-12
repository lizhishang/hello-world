package com.zhishang.gof.builder;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 21:19 2019-02-01
 */
public class InstanceAirShipBuilder implements AirShipBuilder{
    @Override
    public OrbitalModule builderOrbitalModule() {
        return new OrbitalModule("simple engine");
    }

    @Override
    public Engine builderEngine() {
        return new Engine("simple engine");
    }

    @Override
    public EscapeTower builderEscapeTower() {
        return new EscapeTower("simple escapeTower");
    }
}

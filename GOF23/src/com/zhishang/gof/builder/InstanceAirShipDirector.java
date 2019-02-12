package com.zhishang.gof.builder;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 21:25 2019-02-01
 */
public class InstanceAirShipDirector implements AirShipDirector {
    private AirShipBuilder builder;

    public InstanceAirShipDirector(AirShipBuilder builder) {
        this.builder = builder;
    }

    @Override
    public AirShip directAirShip() {
        AirShip ship = new AirShip();
        ship.setEngine(builder.builderEngine());
        ship.setEscapeTower(builder.builderEscapeTower());
        ship.setOrbitalModule(builder.builderOrbitalModule());

        return ship;
    }
}

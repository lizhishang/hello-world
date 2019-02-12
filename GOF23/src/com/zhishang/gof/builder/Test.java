package com.zhishang.gof.builder;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 21:31 2019-02-01
 */
public class Test {
    public static void main(String[] args) {
        AirShip ship = new InstanceAirShipDirector(new InstanceAirShipBuilder()).directAirShip();
        System.out.println(ship);
        ship.launch();
    }
}

package com.zhishang.gof.decorator;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:50 2019-02-02
 */
public class Client {
    public static void main(String[] args) {
        Car car = new Car();

        SuperCar superCar = new SuperCar(car);
        superCar.move();

        FlyCar flyCar = new FlyCar(superCar);
        flyCar.move();

        WaterCar waterCar = new WaterCar(flyCar);
        waterCar.move();

        AICar aiCar = new AICar(waterCar);
        aiCar.move();
    }
}

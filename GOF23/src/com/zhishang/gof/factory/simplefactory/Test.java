package com.zhishang.gof.factory.simplefactory;

import com.zhishang.gof.factory.bean.Car;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:06 2019-02-01
 */
public class Test {
    public static void main(String[] args) {
        Car car1 = CarFactory.createCar("audi");
        Car car2 = CarFactory.createCar("byd");

        System.out.println(car1);
        System.out.println(car2);
    }
}

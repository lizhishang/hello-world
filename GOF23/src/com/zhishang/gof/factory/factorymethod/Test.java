package com.zhishang.gof.factory.factorymethod;

import com.zhishang.gof.factory.bean.Car;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:23 2019-02-01
 */
public class Test {
    public static void main(String[] args) {
        Car c1 = new AudiFactory().createCar();
        Car c2 = new BydFactory().createCar();
        Car c3 = new BenzFactory().createCar();

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }
}

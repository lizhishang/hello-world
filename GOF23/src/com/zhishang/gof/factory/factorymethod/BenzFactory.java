package com.zhishang.gof.factory.factorymethod;

import com.zhishang.gof.factory.bean.Benz;
import com.zhishang.gof.factory.bean.Car;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:25 2019-02-01
 */
public class BenzFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Benz();
    }
}

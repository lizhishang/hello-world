package com.zhishang.gof.factory.factorymethod;

import com.zhishang.gof.factory.bean.Audi;
import com.zhishang.gof.factory.bean.Car;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:21 2019-02-01
 */
public class AudiFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Audi();
    }
}

package com.zhishang.gof.factory.factorymethod;

import com.zhishang.gof.factory.bean.Byd;
import com.zhishang.gof.factory.bean.Car;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:23 2019-02-01
 */
public class BydFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Byd();
    }
}

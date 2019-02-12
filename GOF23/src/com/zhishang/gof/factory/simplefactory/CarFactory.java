package com.zhishang.gof.factory.simplefactory;

import com.zhishang.gof.factory.bean.Audi;
import com.zhishang.gof.factory.bean.Byd;
import com.zhishang.gof.factory.bean.Car;

/**
 * Simple static CarFactory
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:01 2019-02-01
 */
public class CarFactory {
    public static Car createCar(String type) {
        switch (type.toLowerCase()) {
            case "audi" :
                return new Audi();
            case "byd" :
                return new Byd();
            default:
                return null;
        }
    }

    public static Car createAudi() {
        return new Audi();
    }

    public static Car createByd() {
        return new Byd();
    }
}

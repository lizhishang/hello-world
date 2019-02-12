package com.zhishang.gof.strategy;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 07:39 2019-02-11
 */
public class NewCustomerManyStrategy implements Strategy {
    @Override
    public double getPrice(double standardPrice) {
        return standardPrice * 0.9;
    }
}

package com.zhishang.gof.factory.bean;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:25 2019-02-01
 */
public class Benz implements Car{
    @Override
    public void run() {
        System.out.println("Benz run");
    }
}

package com.zhishang.gof.factory.bean;

/**
 * Super class Car
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 19:57 2019-02-01
 */
public class Audi implements Car{
    @Override
    public void run() {
        System.out.println("Audi run");
    }
}

package com.zhishang.gof.factory.bean;

/**
 * Super class Car
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 19:58 2019-02-01
 */
public class Byd implements Car {
    @Override
    public void run() {
        System.out.println("Byd run");
    }
}

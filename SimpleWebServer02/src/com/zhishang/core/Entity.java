package com.zhishang.core;

/*
 * TODO
 *
 * @project_name    hello-world
 * @author          zhishangli
 * @time            16:21 2019-01-28
 */
public class Entity {
    private String name;
    private String clz;

    public Entity() {
    }

    public Entity(String name, String clz) {
        this.name = name;
        this.clz = clz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClz() {
        return clz;
    }

    public void setClz(String clz) {
        this.clz = clz;
    }

    @Override
    public String toString() {
        return "com.zhishang.core.Entity{" +
                "name='" + name + '\'' +
                ", clz='" + clz + '\'' +
                '}';
    }
}

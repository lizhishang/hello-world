package com.zhishang.gof.mediator;

public interface Mediator {
    void register(String dname, Department department);
    void command(String dname);
}

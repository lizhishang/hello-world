package com.zhishang.gof.memento;

/**
 * 负责人类
 * 管理备忘录对象
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 12:00 2019-02-12
 */
public class CareTaker {
    private EmpMemento memento;

    public EmpMemento getMemento() {
        return memento;
    }

    public void setMemento(EmpMemento memento) {
        this.memento = memento;
    }
}

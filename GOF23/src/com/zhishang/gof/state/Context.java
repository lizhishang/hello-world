package com.zhishang.gof.state;

/**
 * 可切换不同状态
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 09:49 2019-02-12
 */
public class Context {
    private State state;

    public void setState(State state) {
        System.out.println("修改状态");
        this.state = state;
        state.handle();
    }

    public State getState() {
        return state;
    }
}

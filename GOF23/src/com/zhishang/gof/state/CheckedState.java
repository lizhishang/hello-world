package com.zhishang.gof.state;

/**
 * 已入住状态
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 09:47 2019-02-12
 */
public class CheckedState implements State {
    @Override
    public void handle() {
        System.out.println("已入住状态");
    }
}


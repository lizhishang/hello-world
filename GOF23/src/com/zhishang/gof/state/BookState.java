package com.zhishang.gof.state;

/**
 * 预定状态
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 09:47 2019-02-12
 */
public class BookState implements State {
    @Override
    public void handle() {
        System.out.println("预定状态");
    }
}


package com.zhishang.gof.command;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 07:13 2019-02-11
 */
public class Invoke {
    private Command command;

    public Invoke(Command command) {
        this.command = command;
    }

    public void move() {
        command.execute();
    }
}

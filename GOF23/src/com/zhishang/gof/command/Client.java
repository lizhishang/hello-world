package com.zhishang.gof.command;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 07:15 2019-02-11
 */
public class Client {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoke invoke = new Invoke(command);

        invoke.move();
    }
}

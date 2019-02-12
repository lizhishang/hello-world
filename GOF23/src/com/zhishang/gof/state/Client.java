package com.zhishang.gof.state;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 09:51 2019-02-12
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();

        context.setState(new FreeState());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        context.setState(new BookState());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        context.setState(new CheckedState());
    }
}

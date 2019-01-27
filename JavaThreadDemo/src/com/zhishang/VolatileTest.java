package com.zhishang;

/*
 * Volatile
 * make variable or data be visible in other thread.
 *
 * @project_name    hello-world
 * @author          zhishangli
 * @time            20:26 2019-01-27
 */
public class VolatileTest {
    private volatile static int num = 0;

    public static void main(String[] args) {
        new Thread(()->{
            while (num == 0){}
        }).start();

        try {
            Thread.sleep(200);
            num = 1;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

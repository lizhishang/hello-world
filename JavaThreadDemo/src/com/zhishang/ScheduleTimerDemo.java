package com.zhishang;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * TODO
 *
 * @project_name    hello-world
 * @author          zhishangli
 * @time            19:52 2019-01-27
 */
public class ScheduleTimerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new MyTask(), new Date(System.currentTimeMillis() + 2000),20);
    }
}
class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("It's time to sleep.");
    }
}

package com.zhishang.thread;

/* *
 * Share resource. Thread will be some problem.
 * */
public class GetTicketThread implements Runnable {
    private static Integer tickets = 99;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (tickets < 1) {
                    break;
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + tickets--);
            }
        }
    }

    public static void main(String[] args) {
        GetTicketThread thread = new GetTicketThread();
        new Thread(thread, "t1:").start();
        new Thread(thread, "t2:").start();
        new Thread(thread, "t3:").start();
    }
}

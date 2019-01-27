package com.zhishang.thread;

public class ThreadMakeByImplement implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadMakeByImplement()).start();
    }
}

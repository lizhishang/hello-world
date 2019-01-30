package com.zhishang.thread;

public class ThreadMakeByExtend extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread");
        }
    }

    public static void main(String[] args) {
        ThreadMakeByExtend thread = new ThreadMakeByExtend();
        //thread.run(); //It doesn't create a new Thread.
        thread.start(); //order by CPU
        for (int i = 0; i < 10; i++) {
            System.out.println("Main");
        }
    }
}

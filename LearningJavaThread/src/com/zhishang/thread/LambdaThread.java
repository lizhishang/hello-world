package com.zhishang.thread;

/*
 * Lambda
 * (parameters) -> expression
 * (parameters) ->{ statements; }
 *
 * @project_name    hello-world
 * @author          zhishangli
 * @time            09:46 2019-01-27
 */
public class LambdaThread {

//  static Inner class
    static class Test1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; ++i) {
                System.out.println("test1 " + i);
            }
        }
    }

    public static void main(String[] args) {
//        new Thread(new Test1()).start();

//        partial class java
//        class Test2 implements Runnable{
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; ++i) {
//                    System.out.println("test2 " + i);
//                }
//            }
//        }
//        new Thread(new Test2()).start();

//      Anonymous inner class must extend super class or implement interface
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; ++i) {
//                    System.out.println("test3 " + i);
//                }
//            }
//        }).start();

//      JDK8 lambda
        new Thread(()-> {
            for (int i = 0; i < 5; ++i) {
                    System.out.println("test4 " + i);
            }
        }).start();
    }
}

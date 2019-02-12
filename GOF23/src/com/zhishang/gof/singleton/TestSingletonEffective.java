package com.zhishang.gof.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 19:24 2019-02-01
 */
public class TestSingletonEffective {
    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();

        //线程记录器
        CountDownLatch count = new CountDownLatch(10);
        for(int j = 0; j < 10; ++j) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000000; ++i) {
                        Object o = SingletonDemo01.getInstance();
                    }
                    //完成后记录器减一
                    count.countDown();
                }
            }).start();
        }
        //线程阻塞，等待其他线程完成后继续。
        count.await();
        long endTime = System.currentTimeMillis();
        System.out.println("waste time -> " + (endTime - startTime));
    }
}

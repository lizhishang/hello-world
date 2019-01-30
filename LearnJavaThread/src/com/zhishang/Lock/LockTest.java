package com.zhishang.Lock;

/*
 * can not Double lock
 *
 * @project_name    hello-world
 * @author          zhishangli
 * @time            21:12 2019-01-27
 */
public class LockTest {
    Lock lock = new Lock();

    public void a() throws InterruptedException {
        lock.lock();
        doSomething();
        lock.unlock();
    }

    private void doSomething() throws InterruptedException {
        lock.lock();
        //test
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest test = new LockTest();
        test.a();
        test.doSomething();
    }
}
class Lock {
    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}

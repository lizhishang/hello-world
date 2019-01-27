package com.zhishang.Lock;

/*
 * can Double lock
 *
 * @project_name    hello-world
 * @author          zhishangli
 * @time            21:12 2019-01-27
 */
public class LockTest02 {
    Relock lock = new Relock();

    public void a() throws InterruptedException {
        lock.lock();
        System.out.println("a " + lock.getHoldCount());
        doSomething();
        lock.unlock();
        System.out.println("a " + lock.getHoldCount());
    }

    private void doSomething() throws InterruptedException {
        lock.lock();
        System.out.println("some " + lock.getHoldCount());
        //test
        lock.unlock();
        System.out.println("some " + lock.getHoldCount());
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest02 test = new LockTest02();
        test.a();
    }
}

class Relock {
    private boolean isLocked = false;
    private Thread lockBy;
    private int holdCount = 0;

    public synchronized void lock() throws InterruptedException {
        Thread t = Thread.currentThread();
        while (isLocked && lockBy != t) {
            wait();
        }
        isLocked = true;
        lockBy = t;
        holdCount++;
    }

    public synchronized void unlock() {
        if (Thread.currentThread() == lockBy) {
            holdCount--;
            if (holdCount == 0) {
                isLocked = false;
                notify();
                lockBy = null;
            }
        }
    }

    public int getHoldCount() {
        return holdCount;
    }
}

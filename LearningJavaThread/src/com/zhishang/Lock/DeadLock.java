package com.zhishang.Lock;

/*
 * TODO
 *
 * @project_name    hello-world
 * @author          zhishangli
 * @time            16:02 2019-01-27
 */
public class DeadLock {
    public static void main(String[] args) {
        new Trade(0).start();
        new Trade(1).start();
    }
}
class Trade extends Thread {
    static Money money = new Money();
    static Good good = new Good();

    int choice;
    int deal;

    public Trade(int choice){
        this.choice = choice;
    }

    @Override
    public void run() {
        try {
            makeADeal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void makeADeal() throws InterruptedException {
        if (choice == 0) {
            synchronized (money) {
                System.out.println("money locked");
                sleep(1000);
                //Here is the problem caused deadlock.
                synchronized (good) {
                    System.out.println("good locked");
                }
            }
//            Here will be solved after you replace the code be a comment
//            synchronized (good) {
//                System.out.println("good locked");
//            }
        } else {
            synchronized (good) {
                System.out.println("Good locked");
                sleep(1000);
                //Here is the problem caused deadlock.
                synchronized (money) {
                    System.out.println("Money locked");
                }
            }
//            Here will be solved after you replace the code be a comment
//            synchronized (money) {
//                System.out.println("Money locked");
//            }
        }
    }
}
class Money {

}
class Good {

}
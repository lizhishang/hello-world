package com.zhishang.thread;

/*
 * Synchronized Sample in withdrawal
 *
 * @project_name    hello-world
 * @author          zhishangli
 * @time            14:10 2019-01-27
 */
public class WithdrawalSafe {
    public static void main(String[] args) {
        Account account = new Account("Six", 100d);
        ATM atm1 = new ATM("Li", account, 40d);
        ATM atm2 = new ATM("Wang", account, 80d);
        atm1.start();
        atm2.start();
    }
}
class ATM extends Thread {
    private String operator;
    private Account target;
    private Double withdraw;

    public ATM(String operator, Account target, Double withdraw) {
        super(operator);
        this.operator = operator;
        this.target = target;
        this.withdraw = withdraw;
    }

    @Override
    public void run() {
        if (target.getMoney() == 0) return;
        synchronized (target) {
            if (target.getMoney() - withdraw < 0) {
                return;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            target.setMoney(target.getMoney() - withdraw);
            System.out.println(operator + " make Account money ->" + target.getMoney());
            System.out.println(operator + " get " + withdraw);
        }
    }
}
class Account {
    private String name;
    private Double money;

    public Account(String name, Double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
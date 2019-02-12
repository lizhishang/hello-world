package com.zhishang.gof.template;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 07:59 2019-02-11
 */
public class Client {
    public static void main(String[] args) {
        BankTemplateMethod drawMoney = new DrawMoney();
        drawMoney.process();

        BankTemplateMethod saveMoney = new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("存钱");
            }
        };
        saveMoney.process();
    }
}

class DrawMoney extends BankTemplateMethod {
    @Override
    public void transact() {
        System.out.println("取钱");
    }
}

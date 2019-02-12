package com.zhishang.gof.template;

/**
 * 模版方法
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 07:56 2019-02-11
 */
public abstract class BankTemplateMethod {
    public void getNumber(){
        System.out.println("排队取号");
    }

    public abstract void transact();

    public void evaluate() {
        System.out.println("评价");
    }

    public final void process() {
        this.getNumber();
        this.transact();
        this.evaluate();
    }
}

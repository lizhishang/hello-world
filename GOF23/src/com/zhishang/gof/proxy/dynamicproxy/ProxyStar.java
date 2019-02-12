package com.zhishang.gof.proxy.dynamicproxy;

/**
 * 模拟动态生成的代理结构
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 16:08 2019-02-02
 */
public class ProxyStar implements Star {
    StarHandler handler;

    public ProxyStar(StarHandler handler) {
        this.handler = handler;
    }

    @Override
    public void confer() {
//        handler.invoke(this, this.getClass(), args);
    }

    @Override
    public void signContract() {
//        handler.invoke(this, this.getClass(), args);
    }

    @Override
    public void bookTicket() {
//        handler.invoke(this, this.getClass(), args);
    }

    @Override
    public void sing() {
//        handler.invoke(this, this.getClass(), args);
    }

    @Override
    public void collectMoney() {
//        handler.invoke(this, this.getClass(), args);
    }
}

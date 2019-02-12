package com.zhishang.gof.observer;

import com.zhishang.gof.state.Context;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 10:15 2019-02-12
 */
public class ConcreteSubject extends Subject{
    private Context context = new Context();

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
        //修改状态后通知所有观察者
        this.notifyAllObserver();
    }
}

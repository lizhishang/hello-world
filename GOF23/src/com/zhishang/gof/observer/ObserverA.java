package com.zhishang.gof.observer;

import com.zhishang.gof.state.State;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 10:22 2019-02-12
 */
public class ObserverA implements Observer {
    private State state;

    @Override
    public void update(Subject subject) {
        state = ((ConcreteSubject)subject).getContext().getState();
    }

    public State getState() {
        return state;
    }
}

package com.zhishang.gof.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 10:10 2019-02-12
 */
public class Subject {
    protected List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyAllObserver() {
        for (Observer o : observers) {
            o.update(this);
        }
    }
}

package com.zhishang.gof.observer;

import com.zhishang.gof.state.BookState;
import com.zhishang.gof.state.CheckedState;
import com.zhishang.gof.state.Context;
import com.zhishang.gof.state.FreeState;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 10:19 2019-02-12
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        Subject subject = new ConcreteSubject();
        Observer observer1 = new ObserverA();
        Observer observer2 = new ObserverA();

        subject.registerObserver(observer1);
        subject.registerObserver(observer2);

        Context context = new Context();
        context.setState(new FreeState());
        ((ConcreteSubject) subject).setContext(context);
        System.out.println(((ObserverA) observer1).getState());
        System.out.println(((ObserverA) observer2).getState());

        Thread.sleep(3000);
        context.setState(new BookState());
        ((ConcreteSubject) subject).setContext(context);
        System.out.println(((ObserverA) observer1).getState());
        System.out.println(((ObserverA) observer2).getState());

        Thread.sleep(3000);
        context.setState(new CheckedState());
        ((ConcreteSubject) subject).setContext(context);
        System.out.println(((ObserverA) observer1).getState());
        System.out.println(((ObserverA) observer2).getState());
    }
}

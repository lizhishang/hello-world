package com.zhishang.gof.memento;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 12:01 2019-02-12
 */
public class Client {
    public static void main(String[] args) {
        CareTaker taker = new CareTaker();

        Emp emp = new Emp("yee", 19, 1000);
        System.out.println(emp);
        taker.setMemento(emp.memento());

        emp.setAge(999);
        emp.setEname("Li");
        emp.setSalary(9999);
        System.out.println(emp);

        emp.recovery(taker.getMemento());
        System.out.println(emp );
    }
}

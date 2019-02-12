package com.zhishang.gof.prototype;

/**
 * 当创建对象十分耗时，建议使用原始模式克隆对象
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 14:02 2019-02-02
 */
public class TestEffective {
    public static void main(String[] args) {
        testClone(10000);
        testNew(10000);
    }

    private static void testNew(int count) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; ++i) {
            Laptop object = new Laptop();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("new -> " + (endTime - startTime));
    }

    private static void testClone(int count) {
        long startTime = System.currentTimeMillis();
        Laptop laptop = new Laptop();
        for (int i = 0; i < count; ++i) {
            try {
                Laptop object = (Laptop) laptop.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("clone -> " + (endTime - startTime));
    }
}
class Laptop implements Cloneable {
    public Laptop() {
        try {
            //模拟创建对象耗时
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

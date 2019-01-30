package com.zhishang;

/*
 * lambda
 * param and return demo
 *
 * @project_name    hello-world
 * @author          zhishangli
 * @time            10:21 2019-01-27
 */
public class LambdaSimpleDemo {

    public static void main(String[] args) {
//        a parameter no return
        TestDo test1 = (int a) ->{
            System.out.println("done -> " + a);
        };
        TestDo test2 = (a) ->{
            System.out.println("done -> " + a);
        };
        TestDo test3 = a -> System.out.println("done -> " + a);

        test1.doIt(100);
        test2.doIt(200);
        test3.doIt(300);


//        parameters and return
        TestAdd testAdd1 = (int a, int b) -> {
            System.out.println(a + b);
            return a + b;
        };
        TestAdd testAdd2 = (a, b) -> {
            System.out.println(a + b);
            return a + b;
        };
        TestAdd testAdd3 = (a, b) -> a + b;
        TestAdd testAdd4 = (a, b) -> 100;

        testAdd1.add(1, 2);
        testAdd2.add(3, 4);
        System.out.println(testAdd3.add(5, 6));
        System.out.println(testAdd4.add(0, 0));
    }
}
interface TestDo {
    void doIt(int test);
}
interface TestAdd {
    int add(int a, int b);
}
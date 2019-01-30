package com.zhishang.test;

import javassist.*;

import java.util.Arrays;

/**
 * learn how to use the javassist API method
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 13:28 2019-01-30
 */
public class Demo02 {
    public static void test01() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get("com.zhishang.test.Emp");
        byte[] bytes = ctClass.toBytecode();
        System.out.println(Arrays.toString(bytes));
        System.out.println("getName:" + ctClass.getName());
        System.out.println("getSimpleName:" + ctClass.getSimpleName());
        System.out.println("getSuperclass:" + ctClass.getSuperclass());
        System.out.println("getInterfaces:" + ctClass.getInterfaces());

        CtField field = new CtField(CtClass.intType, "salary", ctClass);
        CtNewMethod.getter("getVip", field);
        CtNewMethod.setter("setVip", field);

    }



    public static void main(String[] args) throws Exception {
        test01();
    }
}

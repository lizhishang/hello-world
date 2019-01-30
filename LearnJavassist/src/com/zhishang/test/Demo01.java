package com.zhishang.test;

import javassist.*;

/**
 * make a class at runtime by javassist
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 12:49 2019-01-30
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("com.zhishang.bean.Emp");

        //add field
        CtField field1 = CtField.make("private int empno;", ctClass);
        CtField field2 = CtField.make("private String ename;", ctClass);
        ctClass.addField(field1);
        ctClass.addField(field2);

        //add method
        CtMethod method1 = CtMethod.make("public int getEmpno(){return this.empno;}", ctClass);
        CtMethod method2 = CtMethod.make("public void setEmpno(int empon){this.empno = empon;}", ctClass);
        ctClass.addMethod(method1);
        ctClass.addMethod(method2);

        //add constructor
        CtConstructor ctConstructor = new CtConstructor(
                new CtClass[]{CtClass.intType, pool.get("java.lang.String")}
                , ctClass);
        ctConstructor.setBody("{this.empno = empno; this.ename = ename;}");
        ctClass.addConstructor(ctConstructor);

        //export folder location
        ctClass.writeFile("/Users/zhishangli/Desktop/");
        System.out.println("You has done!");
    }
}

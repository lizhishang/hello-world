package com.zhishang.test;

/**
 * java.lang.Class simple use and compare
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:34 2019-01-29
 */
public class Demo01 {
    public static void main(String[] args) {
        String path = "com.zhishang.bean.User";
        try {
            //Class.forName();
            Class clazz1 = Class.forName(path);
            //clazz1 is the same as clazz2
            Class clazz2 = Class.forName(path);
            System.out.println(clazz1 == clazz2);

            //This is new by className.class
            Class clazz3 = String.class;
            //clazz3 is the same as clazz4
            Class clazz4 = path.getClass();
            System.out.println(clazz3 == clazz4);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

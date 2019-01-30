package com.zhishang.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 利用反射API，获取类的信息（类的名字、属性、构造方法、构造器）;
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 21:51 2019-01-29
 */
public class Demo02 {
    public static void main(String[] args) {
        String path = "com.zhishang.bean.User";
        try {
            //Class.forName();
            Class clazz1 = Class.forName(path);

            //Class.name
            System.out.println(clazz1.getName());
            System.out.println(clazz1.getSimpleName());

            //Class.Field
//            just can get public fields
//            Field[] fields = clazz1.getFields();
//            just can get all fields
            Field[] fields = clazz1.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field.getName());
            }

            //Class.method
            Method[] methods = clazz1.getDeclaredMethods();
            //You should make sure the parameter of class in method which you want to get
            Method method = clazz1.getDeclaredMethod("getUname", null);

            //Class.constructor
            Constructor[] constructors = clazz1.getDeclaredConstructors();
            Constructor constructor = clazz1.getConstructor(String.class, String.class, int.class);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

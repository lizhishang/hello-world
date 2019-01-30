package com.zhishang.test;

import com.zhishang.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射API动态的操作：构造器、方法、属性
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 22:12 2019-01-29
 */
public class Demo03 {
    public static void main(String[] args) {
        String path = "com.zhishang.bean.User";
        try {
            //Class.forName();
            Class clazz = Class.forName(path);

            //动态构造对象
            Constructor constructor1 = clazz.getConstructor(String.class, String.class, int.class);
            User user1 = (User) constructor1.newInstance("a", "b", 12);
            System.out.println(user1);

            //通过反射API调用普通方法
            User user2 = (User) clazz.getConstructor().newInstance();
            Method method = clazz.getDeclaredMethod("setUname", String.class);
            method.invoke(user2, "ok");
            System.out.println(user2);

            //通过反射API调用属性
            User user3 = (User) clazz.getConstructor().newInstance();
            Field field = clazz.getDeclaredField("pwd");
            //使私有属性不需要安全检查，可以直接修改 可以增加效率
            field.setAccessible(true);
            field.set(user3, "mush");
            System.out.println(user3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

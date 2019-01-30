package com.zhishang.test;


import com.zhishang.sample.TableField;
import com.zhishang.sample.TableName;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用Reflection读取Annotation信息，模拟处理注解信息的流程
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 20:00 2019-01-29
 */
public class Demo04 {
    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("com.zhishang.sample.Student");
        //获取class所有有效注解
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a : annotations) {
            System.out.println(a);
        }
        //通过注解类获取对应属性
        TableName tableName = (TableName) clazz.getAnnotation(TableName.class);
        System.out.println(tableName.value());
        //获得类的属性的注解
        Field[] fields  = clazz.getDeclaredFields();
        for (Field field : fields) {
            TableField tableField = field.getAnnotation(TableField.class);
            System.out.println(tableField.columnName() + " - " + tableField.type() + " - " + tableField.length());
        }
    }
}

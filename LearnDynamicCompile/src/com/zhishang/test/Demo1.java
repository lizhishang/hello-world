package com.zhishang.test;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Learn simple Dynamic Compile
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 09:26 2019-01-30
 */
public class Demo1 {
    public static void main(String[] args) throws Exception {
        //从客户端接收在线输入的代码，通过IO流打包成java文件，再调用动态方法编译
        //必须要进行安全检查。哪些可以写，哪些会你对造成不良影响也要过滤

        //动态编译java文件
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        int result = javaCompiler.run(null, null, null, "/Users/zhishangli/Desktop/Test.java");
        System.out.println(result == 0 ? "success" : "fail");

        //动态执行class文件
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("java -cp /Users/zhishangli/Desktop Test");

        //通过流读取文件执行内容
        /*InputStream in = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String info = "";
        while ((info = reader.readLine()) != null) {
            System.out.println(info);
        }*/

        URL[] urls = new URL[]{new URL("file://" + "/Users/zhishangli/Desktop/")};
        URLClassLoader loader = new URLClassLoader(urls);
        Class clazz = loader.loadClass("Test");
        Method method = clazz.getMethod("main", String[].class);

        //public static void main("a", "b"); error
//        method.invoke(null, /*(Object)*/new String[]{"a", "b"});

        //public static void main(String[] args);
        method.invoke(null, (Object)new String[]{});
    }
}

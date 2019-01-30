package com.zhishang.test;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.net.URL;

/**
 * java通过脚本引擎运用javascript
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 10:31 2019-01-30
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        //通过名字获得对应引擎
        ScriptEngine engine = manager.getEngineByName("javascript");

        //定义变量 存储到引擎上下文
        engine.put("msg", "javascript");
        String user = "var user = {name:'test', age:18, school:['哈尔滨佛学院', '华强北']};";
        user += "java.lang.System.out.println(user.name);";

        //执行脚本
        engine.eval(user);
        engine.eval("msg = 'six six six'");
        System.out.println(engine.get("msg"));

        //定义函数
        engine.eval("function add(a, b){" +
                            "   var sum = a + b;" +
                            "   return sum;" +
                            "}");
        //执行js函数
        //取得调用接口
        Invocable jsInvoke = (Invocable) engine;
        //执行脚本中定义的方法
        Object result = jsInvoke.invokeFunction("add", 12, 12);
        System.out.println(result);

        //导入其他java包，使用其他包中的java类
        //This sample is not working because i get error and i don't know how to solve. so sad.
        /*String jscode = "importPackage(java.util); var list = Arrays.asList(['testOne', 'testTwo', 'testThree']);";
        engine.eval(jscode);

        List list = (List) engine.get("list");
        for (Object temp : list) {
            System.out.println(temp);
        }*/

        //执行一个js文件
        URL url = Demo01.class.getClassLoader().getResource("test.js");
        FileReader reader = new FileReader(url.getPath());
        engine.eval(reader);
        reader.close();
    }
}

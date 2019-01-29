package com.zhishang.core;

import com.zhishang.servlet.ErrorServlet;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * TODO
 *
 * @author zhishangli
 * @project_name hello-world
 * @time 14:19 2019-01-29
 */
public class WebApp {
    private static WebContext context;
    static {
        try {
//            SAX解析
//        1、获得解析工厂
            SAXParserFactory factory = SAXParserFactory.newInstance();
//        2、从解析工厂获得解析器
            SAXParser parser = factory.newSAXParser();
//        3、加载文档Document注册处理器
//        4、编写处理器
            WebHandler handler = new WebHandler();
//        5、解析
            parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("web.xml"), handler);

            context = new WebContext(handler.getEntities(), handler.getMappings());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过url获得对应servlet
     * @param url
     * @return
     */
    public static Servlet getServletFromUrl(String url) {
        try {
            String classname = context.getClassName("/" + url);
            if (classname == null || classname.trim().length() < 1){
                return new ErrorServlet();
            }
            Class clz = Class.forName(classname);
            Servlet servlet = (Servlet) clz.getConstructor().newInstance();
            return servlet;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}

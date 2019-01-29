package servlet;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @project_name    hello-world
 * @author          zhishangli
 * @time            15:10 2019-01-28
 */
public class Xml_SAX {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        SAX解析
//        1、获得解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
//        2、从解析工厂获得解析器
        SAXParser parser = factory.newSAXParser();
//        3、加载文档Document注册处理器
//        4、编写处理器
        WebHandler handler = new WebHandler();
//        5、解析
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("servlet/web.xml"), handler);
//        获取数据
        WebContext context = new WebContext(handler.getEntities(), handler.getMappings());

        Class classtest1 = Class.forName(context.getClassName("/login"));
        Servlet servlet = (Servlet)classtest1.getConstructor().newInstance();
        System.out.println(classtest1);
        servlet.service();
    }
}

/**
 * 解析xml文件中的标签
 * 获取特定的值并打包进入容器中
 */
class WebHandler extends DefaultHandler {
    private List<Entity> entities;
    private List<Mapping> mappings;
    private Entity entity;
    private Mapping mapping;
    private String tag;
    private boolean isMapping = false;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("---start---");
        entities = new ArrayList<Entity>();
        mappings = new ArrayList<Mapping>();
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("---end---");
//        System.out.println(entities);
//        System.out.println(mappings);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        System.out.println(qName + " parse start");
        if (null != qName) {
            tag = qName;
            if(qName.equals("servlet")) {
                entity = new Entity();
                isMapping = false;
            }
            if(qName.equals("servlet-mapping")) {
                mapping = new Mapping();
                isMapping = true;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
//        System.out.println(qName + " parse end");
        if (qName.equals("servlet")) {
            entities.add(entity);
        }
        if (qName.equals("servlet-mapping")) {
            mappings.add(mapping);
            isMapping = false;
        }
        tag = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length).trim();
        if (str.length() < 1) return;
        if (null != tag) {
            if (isMapping) {
                if (tag.equals("servlet-name")) {
                    mapping.setName(str);
                } else if (tag.equals("url-pattern")) {
                    mapping.addPattern(str);
                }
            } else {
                if (tag.equals("servlet-name")) {
                    entity.setName(str);
                } else if (tag.equals("servlet-class")) {
                    entity.setClz(str);
                }
            }
        }
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public List<Mapping> getMappings() {
        return mappings;
    }
}
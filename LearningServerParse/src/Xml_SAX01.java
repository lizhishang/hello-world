import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/*
 * TODO
 *
 * @project_name    hello-world
 * @author          zhishangli
 * @time            15:10 2019-01-28
 */
public class Xml_SAX01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
//        SAX解析
//        1、获得解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
//        2、从解析工厂获得解析器
        SAXParser parser = factory.newSAXParser();
//        3、加载文档Document注册处理器
//        4、编写处理器
        pHanderl handler = new pHanderl();
//        5、解析
        parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("test.xml"), handler);
    }
}
class pHanderl extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("---start---");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("---end---");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName + " parse start");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName + " parse end");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length).trim();
        if (str.length() < 1) return;
        System.out.println("context:-> " + str);
    }
}
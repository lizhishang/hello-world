package com.zhishang.core;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

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
//        System.out.println("---start---");
        entities = new ArrayList<Entity>();
        mappings = new ArrayList<Mapping>();
    }

    @Override
    public void endDocument() throws SAXException {
//        System.out.println("---end---");
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
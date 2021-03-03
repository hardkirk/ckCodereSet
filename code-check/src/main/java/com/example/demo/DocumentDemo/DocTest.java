package com.example.demo.DocumentDemo;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


/**
 * @Author chuke
 * @create 2020/11/24 15:24
 */
public class DocTest {

    public static void main(String[] args) throws Exception {
        String xmlContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><school><student><id>0001</id></student></school>";
        Document document = DocumentHelper.parseText(xmlContent);//获取Document对象
        Element root = document.getRootElement();//获取根结点
        Element student = root.element("student");//获取子结点
        Element id = student.element("id");//获取子子结点
        System.out.println("id:" + id.getTextTrim());
    }


}

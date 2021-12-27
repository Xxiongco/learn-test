import java.io.*;
import java.util.Objects;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;

public class Test {
    public static String NAME = "name";
    public static String AGE = "age";
    public static String NUM = "num";
    public static void main(String[] args) throws Exception {
        //test1();
        test2();
    }

    public static void test3(){
        
    }

    public static void test2() throws Exception{
        Document document = getDocument();
        NodeList root = document.getChildNodes();
        Node item = root.item(0);
        System.out.println( item.getNodeName() +" node length : "  + root.getLength());

        NodeList childNodes = item.getChildNodes();
        System.out.println("childNodes length : "  + childNodes.getLength());

        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
//            if("student".equals(node.getNodeName())){
//                System.out.println(node.getNodeName());
//            }

            System.out.println(node.getNodeName());


        }


    }

    public static void test1() throws Exception{

        Document doc = getDocument();
        // 获取了根节点
        Element root = doc.getDocumentElement();
        // com.sun.org.apache.xerces.internal.dom.DeferredElementImpl
        System.out.println(root.getClass().getName());
        System.out.println(root.getNodeName());

        System.out.println("******************************");

        NodeList students = root.getElementsByTagName("student");
        // com.sun.org.apache.xerces.internal.dom.DeepNodeListImpl
        System.out.println(students);

        for(int i = 0;i < students.getLength() ; i ++){
            Element element = (Element)students.item(i);
            System.out.println(element.getNodeName());
            System.out.println(element.getElementsByTagName(NAME).item(0).getFirstChild().getNodeValue());
            System.out.println(element.getElementsByTagName(AGE).item(0).getFirstChild().getNodeValue());
            System.out.println(element.getElementsByTagName(NUM).item(0).getFirstChild().getNodeValue());
        }

        System.out.println("******************************");

        NodeList childNodes = root.getChildNodes();
        // com.sun.org.apache.xerces.internal.dom.DeferredElementImpl
        System.out.println(childNodes.getClass().getName());

        for(int i = 0;i < childNodes.getLength() ; i ++){
            Node node = childNodes.item(i);
            System.out.println(node.getNodeName());
        }
    }
    public static Document getDocument() throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream resourceAsStream = Test.class.getClassLoader().getResourceAsStream("test.xml");
        Document doc = builder.parse(resourceAsStream);

        return doc;
    }




}
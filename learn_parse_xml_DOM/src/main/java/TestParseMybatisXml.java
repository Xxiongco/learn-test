import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class TestParseMybatisXml {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream resourceAsStream = Test.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        Document document = builder.parse(resourceAsStream);

        // 获取mapper节点
        NodeList mapperList = document.getElementsByTagName("mapper");
        for(int i = 0;i<mapperList.getLength();i++){
            Node mapperNode = mapperList.item(i);
            if(mapperNode.hasAttributes()){
                // 找到mapper节点的namespace属性节点
                // NamedNodeMap attributes = mapperNode.getAttributes();
                Node namespace = mapperNode.getAttributes().getNamedItem("namespace");
                // namespace属性节点内容
                System.out.println(namespace.getNodeValue());
            }
            if(mapperNode.hasChildNodes()){
                // mapper节点的子节点
                NodeList childNodes = mapperNode.getChildNodes();
                // 遍历子节点
                for(int j = 0;j<childNodes.getLength();j++){
                    Node childNode = childNodes.item(j);
                    if("resultMap".equals(childNode.getNodeName())){
                        //TODO
                    } else if("select".equals(childNode.getNodeName())){
                        //TODO
                    } else if("insert".equals(childNode.getNodeName())){
                        //TODO
                    }
                }
            }
        }

    }
}

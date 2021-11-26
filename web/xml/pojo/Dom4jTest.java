package xml.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/**
 * @ClassName Dom4jTest
 * @Description TODO
 * @Author 城南
 * @Date 2021/10/27 9:46
 * @Version 1.0
 **/
public class Dom4jTest {
    @Test
    public void test1(){
        //创建一个saxreader输入流，去读取xml配置文件，生成document对象
        SAXReader saxReader=new SAXReader();
        try {

            Document document=saxReader.read("src/xml/books.xml");
            System.out.println(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}

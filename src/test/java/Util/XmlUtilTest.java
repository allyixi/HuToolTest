package Util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.XmlUtil;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.xpath.XPathConstants;


public class XmlUtilTest {
    // 读取xml为Document
    // 获取xml内容通过操控Document对象即可
    @Test
    public void test01() {
        // XmlUtil.readXML 读取XML文件
        // XmlUtil.parseXml 解析XML字符串为Document对象
        Document document = XmlUtil.readXML(FileUtil.file("/Users/lixinyu/lxy/test/GF1_PMS1_E98.1_N41.6_20160903_L1A0001802606-MSS1.xml"));
        System.out.println(document.getElementsByTagName("SatelliteID").item(0).getFirstChild().getNodeValue());
    }

    // 写XML
    @Test
    public void test02() {
        // XmlUtil.toStr 将XML文档转换为String
        // XmlUtil.toFile 将XML文档写入到文件
        // XmlUtil.createXml 创建XML文档, 创建的XML默认是utf8编码，修改编码的过程是在toStr和toFile方法里，既XML在转为文本的时候才定义编码。
        Document document = XmlUtil.readXML(FileUtil.file("/Users/lixinyu/lxy/test/GF1_PMS1_E98.1_N41.6_20160903_L1A0001802606-MSS1.xml"));
        System.out.println(XmlUtil.toStr(document));
    }

    // xml操作
    // XmlUtil.cleanInvalid 除XML文本中的无效字符
    // XmlUtil.getElements 根据节点名获得子节点列表 返回Element
    // XmlUtil.getElement 根据节点名获得第一个子节点 返回Element
    // XmlUtil.elementText 根据节点名获得第一个子节点 返回String
    // XmlUtil.transElements 将NodeList转换为Element列表
    @Test
    public void test03() {
        Document document = XmlUtil.readXML(FileUtil.file("/Users/lixinyu/lxy/test/GF1_PMS1_E98.1_N41.6_20160903_L1A0001802606-MSS1.xml"));
        Element element = XmlUtil.getElement(document.getDocumentElement(), "SatelliteID");
        System.out.println(element.getFirstChild().getNodeValue());
        System.out.println(XmlUtil.elementText(document.getDocumentElement(), "SatelliteID"));
    }

    // xml与对象转换
    @Test
    public void test04() {
        // writeObjectAsXml 将可序列化的对象转换为XML写入文件，已经存在的文件将被覆盖
        // readObjectFromXml 从XML中读取对象
    }

    // Xpath操作
    @Test
    public void test05(){
        // createXPath 创建XPath
        // getByXPath 通过XPath方式读取XML节点等信息 //找tag /路径
        Document document = XmlUtil.readXML(FileUtil.file("/Users/lixinyu/lxy/test/GF1_PMS1_E98.1_N41.6_20160903_L1A0001802606-MSS1.xml"));
        //找得到
        Object value = XmlUtil.getByXPath("//SatelliteID", document, XPathConstants.STRING);
        System.out.println(value);
        //找得到
        Object value1 = XmlUtil.getByXPath("/ProductMetaData/SatelliteID", document, XPathConstants.STRING);
        System.out.println(value1);
        //找不到
        Object value2 = XmlUtil.getByXPath("/SatelliteID", document, XPathConstants.STRING);
        System.out.println(value2);
    }
}

package xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * xml��string֮���ת��
 * @author dell
 *
 */
public class Xml2Str {
	public static void main(String[] args) throws Exception {
		Xml2Str x = new Xml2Str();
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("sdmz.xml"));
		Element root = document.getRootElement();  
		// ���ĵ�ת���ַ���
		String xmlStr = root.asXML();
		System.out.println(xmlStr);
		System.out.println("---------------------------");  
		String xmlStr1 = document.asXML();
		System.out.println(xmlStr1);
		System.out.println("---------------------------");  
		
		//��ȡ��ǩ
		Element xyj = root.element("���μ�");
		String xyjStr = xyj.asXML();
		System.out.println(xyjStr);
		System.out.println("---------------------------");  
		
		//ת��xml
		Document document2 = DocumentHelper.createDocument();
		Element abcd = document2.addElement("abcd");
		Element java = abcd.addElement("java");
		java.setText("java1234");
		Element ios = abcd.addElement("ios");
		ios.setText("ios1234");
		x.Writer(document2);
		
		String docStr = document2.asXML();
		System.out.println(docStr);
	}

	private  void Writer(Document document) throws Exception {
		 // �Ű������ĸ�ʽ  
        OutputFormat format = OutputFormat.createPrettyPrint();  
        XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream("sdmz.xml"),"UTF-8"),format);
        writer.write(document);  
        // ����д��  
        writer.flush();  
        // �رղ���  
        writer.close(); 
	
	
	}
}

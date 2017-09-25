package xml;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.w3c.dom.Node;

/**
 * dom4j����xml
 * �ڶ��ֺ͵������ʺϽ��ļ�д��xml
 * @author dell
 *
 */
@SuppressWarnings("all")
public class xmlJX {
	public static void main(String[] args) throws Exception {
		/*DOM4j�У����Document����ķ�ʽ������*/
		//1.��ȡXML�ļ�,���document����   
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("sdmz.xml"));
//		//2.����XML��ʽ���ı�,�õ�document����
//		String text = "<�Ĵ�����></�Ĵ�����>";
//		Document document1 = DocumentHelper.parseText(text);
//		//3.��������document����
//		Document document2 = DocumentHelper.createDocument();
//		Element rootElement = document2.addElement("�Ĵ�����");
		
		
		/*�ڵ��������ķ���*/
		//1.��ȡ�ĵ��ĸ��ڵ�
		Element root = document.getRootElement();
		//2.ȡ��ĳ���ڵ���ӽڵ�
		Element element = root.element("���μ�");
		//3.ȡ�ýڵ��м�������  
		String rootName = root.getText();
		//4.ȡ��ĳ�ڵ���������Ϊ��xxxx�����ӽڵ㣬�����б���
		List nodes = root.elements("���μ�");
		for (Iterator it = nodes.iterator();  it.hasNext();) {
			Element ele = (Element) it.next();	
		}
//		Iterator it1 = nodes.iterator();
//		while(it1.hasNext()){//���ֻ��һ����if
//			Element e = (Element) it1.next();
//			System.out.println(e.getText());
//		}
		//5.��ĳ�ڵ��µ������ӽڵ���б���
//		List noeds1 = root.elements();
//		for (Iterator it = noeds1.iterator();  it.hasNext();) {
//			Element ele = (Element) it.next();	
//		}
		// 6.��ĳ�ڵ�������ӽڵ� 
		Element elm = root.addElement("���");
		// 7.���ýڵ�����
		elm.setText("����");
		// 8.ɾ��ĳ�ڵ�.//childElement�Ǵ�ɾ���Ľڵ�,parentElement���丸�ڵ�  parentElement.remove(childElment);
		root.remove(elm);
		//9.���һ��CDATA�ڵ�.
		Element content = root.addElement("content");
		content.addCDATA("cdata");
		
		/*�ڵ��������Է�������*/
		//1.ȡ��ĳ�ڵ��µ�ĳ����
		Attribute attr = element.attribute("id");
		// 2.ȡ�����Ե����� 
		//attr.getText();
		// 3.ɾ��ĳ����
		element.remove(attr);
		//4.����ĳ�ڵ����������
		for (Iterator it = root.attributeIterator() ; it.hasNext();) {
			Attribute at = (Attribute) it.next();
			System.out.println(at.getText());
			
		}
		//5.����ĳ�ڵ�����Ժ�����.
		element.addAttribute("name","1234");
		//6.�������Ե�����
		Attribute at = element.attribute("name");
		at.getText();
		
		/*���ĵ�д��XML�ļ�*/
		//1.�ĵ���ȫΪӢ��,�����ñ���,ֱ��д�����ʽ.
		XMLWriter writer = new XMLWriter(new FileWriter("sdmz.xml"));
		writer.write(document);
		writer.close();
		// 2.�ĵ��к�������,���ñ����ʽд�����ʽ.
		// �����ļ������ʱ���Զ������ĸ�ʽ              
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer2 = new XMLWriter(new FileWriter("sdmz.xml"),format);
		writer2.write(document);
		writer2.close();
		
		/*�ַ�����XML��ת��*/
		//1.���ַ���ת��ΪXML  
	    String text = "<csdn> <java>Java��</java></csdn>";  
		Document document2 = DocumentHelper.parseText(text);
		// 2.���ĵ���ڵ��XMLת��Ϊ�ַ���.
		String domXml = document.asXML();
		
		
		System.out.println(at.getText());
		
		
	}
}

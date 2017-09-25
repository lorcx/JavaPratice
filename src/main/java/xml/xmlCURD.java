package xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

public class xmlCURD {
//	public static void main(String[] args) throws Exception {
//		xmlCURD xml = new xmlCURD();
//		SAXReader reader = new SAXReader();
//		Document document = reader.read(new File("sdmz.xml"));
//		//���ڵ�
//		Element root = document.getRootElement();
//		Element element = root.element("���μ�");
//
//		//�ڵ�����Ա���
//		xml.listnodes(element);
//
//		Element xyj = root.element("���μ�");
//		Attribute attr = xyj.attribute("id");
//		xyj.remove(attr);//�Ƴ�����
//		//���������
//		element.addAttribute("name", "��ж�");
//		//����½ڵ�
//		Element newEle = element.addElement("����");
//		newEle.setText("�峯");
//		//�Ƴ��ڵ�
//		Element zz = xyj.element("����");
//		boolean b = xyj.remove(zz);
//		System.out.println(b?"ɾ���ɹ�":"ɾ��ʧ��");
//		//���cdata����
//		xyj.addCDATA("��¥��û����");
//		xml.writer(document);
//		System.out.println("----------------------------------");
//		xml.listnodes(element);
//
//	}
//	/**
//	 * д�뵽xml
//	 * @param document
//	 * @throws Exception
//	 */
//	private  void writer(Document document) throws Exception {
//	    // ���յĸ�ʽ
//        // OutputFormat format = OutputFormat.createCompactFormat();
//		// �Ű������ĸ�ʽ
//        OutputFormat format = OutputFormat.createPrettyPrint();
//        // ���ñ���
//        format.setEncoding("UTF-8");
//        // ����XMLWriter����,ָ����д���ļ��������ʽ
//        //src��         "src//sdml.xml"
//        XMLWriter xml = new XMLWriter(new OutputStreamWriter(new FileOutputStream("sdml.xml"),"UTF-8"),format);
//        xml.write(document);
//        xml.flush();
//        xml.close();
//
//
//
//	}
//	/**
//	 * �ڵ����Ա���
//	 * @param element
//	 */
//	public void listnodes(Element element){
//		System.out.println("��ǰ�ڵ�����"+element.getName());
//		//��ȡ��ǰ�ڵ��µ��������Խڵ�
//		List<Attribute> list = element.attributes();
//		for (Attribute attr : list) {
//			System.out.println(attr.getText()+"------"+attr.getName());
//		}
//
//		if(!element.getTextTrim().equals("")){
//			System.out.println("�ı����ݣ�������" + element.getText());
//		}
//		//��ȡ�������ӽڵ�
//		for (Iterator it = element.elementIterator(); it.hasNext(); ) {
//			Element ele = (Element) it.next();
//			listnodes(ele);
//		}
//
//	}
}

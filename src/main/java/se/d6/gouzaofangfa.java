package se.d6;
/**
 *
 *�����ˣ�lixin     
 *����ʱ�䣺2014-12-15 ����10:58:24
 *���������ø���Ĺ��췽��
 */
/**
 * ����Ը��෽�����ɼ�
 * @author dell
 *
 */
public class gouzaofangfa {
	public String s;
	public gouzaofangfa(){
	}
	public gouzaofangfa(String str){
		s = str;
	}
	public void a(){
		
	}
	public static void main(String[] args) {
		gouzaofangfa g = new gouzaofangfa();
	}
}
class xx extends gouzaofangfa{
	public String strl;
	public xx(){
		super("abc");//���ø���Ĵ��������췽��
		super.a();//���ø���ķ���
	}
	public static void main(String[] args) {
		xx x = new xx();
		System.out.println(x.s);
		x.a();
	}
	public void b(){
		
	}
}
package se.se.d6;
/**
 *
 *�����ˣ�lixin     
 *����ʱ�䣺2014-12-15 ����11:23:17
 *���������ñ����ص����Ժͷ���
 */
public class diaoyongyincang {
	public String str = "123";
	public  void a(){
		System.out.println("method1");
	}
}
class c extends diaoyongyincang{
	public String str = "456";
	public c(){
		
		System.out.println(super.str);//���ø��౻���ص�����
		super.a();//���ø���ķ���
	}
	public void a(){
		System.out.println("method2");
	}
	public static void main(String[] args) {
		c d = new c();
	}
}

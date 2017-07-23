package se.se.d6;


/**
 *
 *�����ˣ�lixin     
 *����ʱ�䣺2014-12-15 ����10:27:32
 *���������ô���
 */
public class YinYongChuanDi {
	public static void main(String[] args) {
		a a = new a();
		System.out.println(a.a);
		test(a);//���ݵ��Ƕ�����ڴ��ַ �βκ�ʵ��ָ��ͬһ��λ��
		System.out.println(a.a);
	}
	public static void test(a a) {
		a.a = 20;
		System.out.println(a.a);
	}
}
class a {
	int a = 10;
}
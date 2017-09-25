package se.d6.qiankelong;

/**
 * 
 * �����ˣ�lixin ����ʱ�䣺2014-12-15 ����11:58:09 ������
 */
/**
 * ǳ��¡ֻ�ܿ�¡������������
 * @author dell
 *
 */
public class Test {
	public static void main(String[] args) {
		Address add = new Address("china", "beijing", "dongcheng");
		employee e1 = new employee("zhangsan",20,add);
		System.out.println(e1.toString());
		employee e2 = e1.clone();
		e2.getAddress().setState("diqiou");
		e2.getAddress().setProvince("tianjin");
		e2.getAddress().setCity("chendu");
		e2.setName("lisi");
		e2.setAge(11);
		System.out.println(e2.toString());
		System.out.println(e1.toString());
		
	}
}

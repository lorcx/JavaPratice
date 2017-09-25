package se;

/**
 * 
 * �����ˣ�lixin ����ʱ�䣺2014-12-11 ����10:37:58 �������洢��ͬ�����ݣ�һά����Ͷ�ά������ռ���ڴ�ռ�
 */
public class YiWeiHeErWei {
	public static void main(String[] args) {
		//һλ����
		int num = 1024 * 1024 * 2;
		int array [] = new int[num];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		long ram =  (Runtime.getRuntime().totalMemory()/1024/1024);//ռ���ڴ��Сת����M
		System.out.println(ram);
		//��ά����
		int er[][] = new int[num][2];
		for (int i = 0; i < er.length; i++) {
			er[i][0] = i;
			er[i][1] = i;
		}
		long ra = Runtime.getRuntime().totalMemory()/1024/1024;
		System.out.println(ra);
	}
}

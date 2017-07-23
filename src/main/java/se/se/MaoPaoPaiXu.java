package se.se;

/**
 * 
 * �����ˣ�lixin ����ʱ�䣺2014-12-10 ����9:52:11 
 * ������ð������ length-1 /-1-i
 */
public class MaoPaoPaiXu {
	public static void main(String[] args) {
		int a[] = {1,4,6,2,62,3,652,56,43};
		int tmp;
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < a.length - i; j++) {
				if(a[j] > a[j+1]){
					tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
				System.out.print(a[j]+" ");
			}
			System.out.print("��");
			for (int j = a.length - i; j < a.length; j++) {
				System.out.print(a[j]+" ");
			}
			System.out.println("��");
		}
	}
}

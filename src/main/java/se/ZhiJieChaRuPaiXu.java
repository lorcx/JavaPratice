package se;

import java.util.Arrays;

/**
 * 
 * �����ˣ�lixin ����ʱ�䣺2014-12-10 ����11:00:51 
 * ������ֱ�Ӳ�������
 */
public class ZhiJieChaRuPaiXu {
	public static void main(String[] args) {
		int a[] = {1,4,6,2,62,3,652,56,43};
		int tmp ;
		int j ;
		for (int i = 1; i < a.length; i++) {
			tmp = a[i];
			for (j = i - 1;j >= 0 && a[j] > tmp; j--) {
				a[j+1] = a[j];
			}
			a[j+1] = tmp;
		}
		System.out.println(Arrays.toString(a));
	}
}

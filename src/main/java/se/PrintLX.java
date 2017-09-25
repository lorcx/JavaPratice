package se;

/**
 * 
 * �����ˣ�lixin ����ʱ�䣺2014-12-9 ����10:45:00 ��������ӡ����
 * ���ѭ��������������
 * ���ѭ�����������������
 */
public class PrintLX {
	public static void main(String[] args) {
		int floor = 7;
		floor = floor % 2 == 0 ? floor + 1 : floor;//תΪ������
		for (int i = 1; i <= floor; i += 2) {//�ϰ�������� 1-4��
			for (int kong = floor; kong > i - 1; kong--) {//����ո�
				System.out.print(" ");
			}
			for (int xing = 1; xing <= i; xing++) {//����Ǻ�
				System.out.print(" *");
			}
			System.out.println();
		}
		for (int j = 1; j <= floor - 2; j += 2) {//�ϰ�������� 5-7��
			for (int kon = 1; kon < j + 3; kon++) {//����ո�
				System.out.print(" ");
			}
			for (int xin = floor - 2; xin >= j ; xin--) {//����Ǻ�
				System.out.print(" *");
			}
			System.out.println();
		}
	}
}

package se.se;

/**
 * 
 * �����ˣ�lixin ����ʱ�䣺2014-12-10 ����9:23:58
 *  ��������ӡ�������
 *  ��ά����[��][��]
 *  ÿ��Ԫ���Ǹ�һά����
 */
public class YhuiSanJiao {
	public static void main(String[] args) {
		int[][] yh = new int[7][];//�����ά����
		for (int i = 0; i < yh.length; i++) {
			yh[i] = new int[i + 1];//�����еĳ���
			for (int j = 0; j <= i; j++) {
				if(j == 0||i == 0||j == i){//�����ÿ�п�ʼ��ÿ�п�ʼ����=��ʱ��1
					yh[i][j] = 1;
				}else{
					yh[i][j] = yh[i-1][j] + yh[i-1][j-1];//ÿ��������һ�е�ֵ�������Ͻǵ�ֵ
				}
				System.out.print(" "+yh[i][j]);
			}
			System.out.println("");
		}
	}
}

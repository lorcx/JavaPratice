package se.se;

/**
 * 
 * �����ˣ�lixin ����ʱ�䣺2014-12-9 ����11:38:19 
 * ����������ѭ��
 */
/**
 * ʹ��break �� continue lab �����ж� �����ѭ��
 * ֻ��breakʱֻ���жϵ�ǰѭ��
 * @author dell
 *
 */
public class tiaochuxunhuan {
	public static void main(String[] args) {
		lab:
		for (int i = 1; i <= 7 ; i += 2) {
			for (int kon = 7; kon > i - 1; kon--) {
				System.out.print(" kong");
//				if( kon == 5){
//					break ;
//				}
			}
			if( i == 5){
				break lab;
			}
			
			System.out.println();
		}
	}
}

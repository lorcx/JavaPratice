package se;
/**
 *
 *�����ˣ�lixin     
 *����ʱ�䣺2014-12-10 ����10:13:08
 *������ѡ������ Ч�ʲ���
 */
public class XuanZePaiXu {
	public static void main(String[] args) {
		int a[] = {1,4,6,2,62,3,652,56,43};
		int index;
		int tmp;//�м����
		String str = "";//�ֲ�����Ҫ��ʼ��
		for (int i = 1; i < a.length; i++) {
			index = 0;//��ʼ��Ϊ0
			for (int j = 1; j < a.length - i; j++) {
				 if(a[j] > a[index]){
					 index = j;//�ҵ����ֵ
				 }
			}
			str = str + a[index] + " ";//ÿ���ƶ���ֵ�������ַ�����
			
			tmp = a[a.length - i];//��ÿ���ҵ������ֵ�Ŵ�a.length - iλ��
			a[a.length - i] = a[index];
			a[index] = tmp;
			
			System.out.print("��");
			for (int j = 0; j < a.length - i; j++) {
				System.out.print(a[j]+" ");
			}
			System.out.println("��" + str);
			
		}
	}
}

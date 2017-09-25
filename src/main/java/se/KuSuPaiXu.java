package se;

/**
 * 
 * �����ˣ�lixin ����ʱ�䣺2014-12-11 ����9:20:16
 *  ��������������
 */
public class KuSuPaiXu {
	public static void main(String[] args) {
		int a[] = {1,4,6,2,62,3,652,56,43};
		quickSort(a, 0, a.length - 1);
	}
	/**
	 * ��������
	 * @param array
	 * @param low
	 * @param height
	 */
	public static void quickSort(int[] array,int low, int height){
		int mid;//�ֽ��Ԫ��
		int lo = low;//��С����
		int hi = height;//�������
		if(low < height){
			mid = array[(low+height)/2];
			while(lo <= hi){
				while((lo < height)&&(array[lo] < mid)){
					lo++;				//�õ���С����
				}
				while((hi > low)&&(array[hi] > mid)){
					hi--;				//�õ��������
				}
				if(lo <= hi){//��С�������������û���ص�
					swap(array,lo,hi);//����λ��
					lo++;
					hi--;
				}
				
			}
			if(lo < height){//�ݹ����û�зֽ��
				quickSort(array, low, hi);
			}
			if(low < hi){//�ݹ��ұ�û�зֽ��
				quickSort(array, lo, height);
			}
		}
		
	}
	/**
	 * ����
	 */
	public static void swap(int[] array,int lo ,int hi){
		int tmp;
		tmp = array[lo];
		array[lo] = array[hi];
		array[hi] = tmp;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}

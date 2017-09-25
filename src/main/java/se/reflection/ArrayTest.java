package se.reflection;


import java.lang.reflect.Array;

public class ArrayTest {
	public static void main(String[] args){
		try{
			//����һ��Ԫ������ΪString������Ϊ10������
			Object arr=Array.newInstance(String.class,10);
			
			//����Ϊarr������indexΪ5��6��Ԫ�ظ�ֵ
			Array.set(arr, 5, "Jack");
			Array.set(arr, 6, "John");
			//����ȡ��arr������indexΪ5��6��Ԫ�ص�ֵ
			Object o1=Array.get(arr, 5);
			Object o2=Array.get(arr, 6);
			//���arr������indexΪ5��6��Ԫ��
			System.out.println(o1);
			System.out.println(o2);
			
		}catch(Throwable e){
			System.err.println(e);
		}
		
		
		
		
		
////		  ����һ����ά����
////		  ˵��������ѧ����ά����Ҳ��һά���飬������Ԫ���Ƕ�ά�����һά���飬��˿�����Ϊarr�ǳ���Ϊ3��һά����
//		  Object arr=Array.newInstance(String.class,3,4,10);
//		  
////		 ��ȡarr������indexΪ2��Ԫ�أ�Ӧ���Ƕ�ά����
//		  Object arrObj = Array.get(arr,2);
//		  
////	     ʹ��ArrayΪ��ά���������Ԫ�ظ�ֵ����ά���������Ԫ����һά���飬���Դ���Array set�����ĵ��������һά����
//		  Array.set(arrObj,2,new String[]{"Jack","John"});
//		  //��ȡarrObj������indexΪ3��Ԫ�أ�Ӧ����һά����
//		  Object anArr=Array.get(arrObj,3);
//		  Array.set(anArr,8,"Lucy");
//		  //��arrǿ������ת��Ϊ��ά����
//		  String[][][] cast=(String[][][])arr;
//		  //��ȡcast��ά������ָ��Ԫ�ص�ֵ
//		  System.out.println(cast[2][3][8]);
//		  System.out.println(cast[2][2][0]);
//		  System.out.println(cast[2][2][1]);

	}
}

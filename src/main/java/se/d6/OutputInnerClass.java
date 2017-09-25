package se.d6;

/** 
 * @Description: 
 * @Create on: Dec 16, 2014 2:11:37 PM
 * @Author:����
 * @Version:1.0
 */
public class OutputInnerClass extends ClassA.ClassB{//�̳��ڲ���
	public OutputInnerClass(ClassA a){
		a.super();
	}
	public static void main(String[] args) {
		ClassA a = new ClassA();
		OutputInnerClass o = new OutputInnerClass(a);
		o.test();
	}
}
 
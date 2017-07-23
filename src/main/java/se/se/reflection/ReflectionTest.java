package se.se.reflection;

/**
 */

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
@SuppressWarnings(value="unchecked")
public class ReflectionTest {
//Ϊ���ඨ��һ��˽�еĹ��췽��
	
	private ReflectionTest(){
		
	}
//����һ���в���Ĺ��췽��
	public ReflectionTest(String name){
		System.out.println("ִ���в���Ĺ��췽��");
	}
	
	//����һ���޲����info����
	public void info(){
		System.out.println("ִ���޲����info����");
	}
	
	//����һ���в����info����
	public void info(String str){
		System.out.println("ִ���в����info������strΪ"+str);
	}
	
	//����һ�������õ��ڲ���
	class Inner{
		
	}
	
	public static void main(String[] args) throws Exception{
		//����Ĵ�����Ի�ȡReflectionTest��Ӧ��Class
		Class<ReflectionTest> cla=ReflectionTest.class;
		//��ȡ��Class�������Ӧ���ȫ�����췽��
		Constructor[] co=cla.getDeclaredConstructors(); 
		System.out.println("ReflectionTest��ȫ�����췽�����£� ");
		for(Constructor c:co){
			System.out.println(c);
		}
		
		//��ȡ��Class�������Ӧ���ȫ��public���췽��
		Constructor[] pubco=cla.getConstructors(); 
		System.out.println("ReflectionTest��ȫ��public���췽�����£� ");
		for(Constructor c:pubco){
			System.out.println(c);
		}
		
		//��ȡ��Class�������Ӧ���ȫ��public����
		Method[] pubmt=cla.getMethods(); 
		System.out.println("ReflectionTest��ȫ��public�������£� ");
		for(Method mt:pubmt){
			System.out.println(mt);
		}
		
		//��ȡ��Class�������Ӧ���ָ������
		System.out.println("ReflectionTest���һ���ַ�����info����Ϊ�� "+cla.getMethod("info", String.class));
		
		//��ȡ��Class�������Ӧ���ȫ��ע��
		Annotation[] anno=cla.getAnnotations(); 
		System.out.println("ReflectionTest��ȫ��Annotation���£� ");
		for(Annotation an:anno){
			System.out.println(an);
		}
		
		/**
		 * ֵ��ע����ǣ���Ȼ����ʹ����@SuppressWarningsע�ͣ�����������ʱ�޷��������������ĸ�ע�ͣ�������Ϊ@SuppressWarnings
		 * ֻ�ܱ�����Դ���뼶���ϣ���ͨ��ReflectionTest.class��ȡ���������ʱClass�������Գ����޷����ʵ�@SuppressWarningsע�͡�
		 * 
		 * ��ʱ��������@SuppressWarnings�¼���@Deprecated����ʱ������Ϣ�ｫ�����@Deprecatedע�͡�
		 * ����һ�����ͻ������ͳ�Աʹ��@Deprecatedע�����εĻ�����������������ʹ���������ע�ĳ���Ԫ�أ�
		 * 
		 * ����һ�¾��У�˵������ע�͵���ϸ֪ʶ�����ǽ��ڽ���������ѧϰ��
		 */
		System.out.println("��ClassԪ���ϵ�@SuppressWarningsע��Ϊ�� "+cla.getAnnotation(SuppressWarnings.class));

		//��ȡ��Class�������Ӧ���ȫ��ע��
		Class<?>[] inners=cla.getDeclaredClasses(); 
		System.out.println("ReflectionTest��ȫ���ڲ������£� ");
		for(Class c:inners){
			System.out.println(c);
		}
		
		//ʹ��Class.forName��������ReflectionTest��Inner�ڲ���
		Class incla=Class.forName("com.pb.jadv.reflection.ReflectionTest$Inner");
		
		//��ȡ��Class�������Ӧ����ⲿ��
		System.out.println("incla��Ӧ����ⲿ��Ϊ�� "+incla.getDeclaringClass());

		System.out.println("ReflectionTest�İ�Ϊ�� "+cla.getPackage());
		System.out.println("ReflectionTest�ĸ���Ϊ�� "+cla.getSuperclass());


	}

}

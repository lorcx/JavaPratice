package design_model.singleton; 
/** 
 * @Description: 单例
 * 单例模式使用内部类来维护单例的实现，
 * JVM内部的机制能够保证当一个类被加载的时候，
 * 这个类的加载过程是线程互斥的
 * @Create on: 2015-2-26 上午10:42:38
 * @Author:李欣
 * @Version:1.0
 */
public class Singleton1 {
	
	/* 私有构造方法，防止被实例化 */ 
	private Singleton1() {
		
	}	
	 /* 此处使用一个内部类来维护单例 */  
	private static class SingletonFactory{
		private static Singleton1 singleton = new Singleton1();
	}
	/*获取实例*/
	public static Singleton1 getInstance(){
		return SingletonFactory.singleton;
	}
	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
	public Object readResolve(){
		return getInstance();
	}
}
 
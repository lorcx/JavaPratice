package design_model.singleton; 
/** 
 * @Description: 单例
 * @Create on: 2015-2-26 上午10:42:38
 * @Author:李欣
 * @Version:1.0
 */
public class Singleton {
	/*持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载*/
	private static Singleton singleton = null;
	/* 私有构造方法，防止被实例化 */ 
	private Singleton() {
		
	}	
	public static Singleton getInstance(){
		if(singleton == null){
			return new Singleton();
		}
		return singleton;
	}
	/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */  
	public Object readResolve(){
		return singleton;
	}
}
 
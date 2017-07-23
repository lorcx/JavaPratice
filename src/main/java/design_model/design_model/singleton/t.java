package design_model.singleton; 
/** 
 * @Description: 
 * @Create on: 2015-2-26 上午11:38:13
 * @Author:李欣
 * @Version:1.0
 */
public class t {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Singleton1 singleton1 = Singleton1.getInstance();
		Singleton1 singleton2 = Singleton1.getInstance();
		if(singleton1 == singleton2){
			System.out.println(1);
		}
	}

}
 
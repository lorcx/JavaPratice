package design_model.Template_Method; 
/** 
 * @Description:模版方法模式
 * @Create on: 2015-2-27 上午11:06:01
 * @Author:李欣
 * @Version:1.0
 */
public class Test {
	public static void main(String[] args) {
		AbstractCalculateor calculateor = new Plus();
		int result = calculateor.calculate("10+20","\\+");
		System.out.println(result);
	}
}
 
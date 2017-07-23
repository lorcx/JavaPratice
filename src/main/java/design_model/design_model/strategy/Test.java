package design_model.strategy; 
/** 
 * @Description: 
 * @Create on: 2015-2-27 上午10:45:30
 * @Author:李欣
 * @Version:1.0
 */
public class Test {
	public static void main(String[] args) {
		ICalculator calculator = new Plus();
		int result = calculator.calculate("1+3");
		System.out.println(result);
	}
}
 
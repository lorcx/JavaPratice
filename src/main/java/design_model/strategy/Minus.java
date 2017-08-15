package design_model.strategy; 
/** 
 * @Description: 减
 * @Create on: 2015-2-27 上午10:40:18
 * @Author:李欣
 * @Version:1.0
 */
public class Minus extends AbstractCalculateor implements ICalculator {

	public int calculate(String exp) {
		int[] arrayInt = split(exp, "-");
		return arrayInt[0] - arrayInt[1];
	}
	
}
 
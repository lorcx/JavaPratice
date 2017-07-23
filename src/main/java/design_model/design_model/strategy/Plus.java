package design_model.strategy; 
/** 
 * @Description: 加法
 * @Create on: 2015-2-27 上午10:37:25
 * @Author:李欣
 * @Version:1.0
 */
public class Plus extends AbstractCalculateor implements ICalculator{

	public int calculate(String exp) {
		int[] arrayInt = split(exp, "\\+");
		return arrayInt[0] + arrayInt[1];
	}

}
 
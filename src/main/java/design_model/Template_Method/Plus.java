package design_model.Template_Method; 
/** 
 * @Description: 
 * @Create on: 2015-2-27 上午11:05:14
 * @Author:李欣
 * @Version:1.0
 */
public class Plus extends AbstractCalculateor{

	@Override
	public int calculate(int num1, int num2) {
		return num1 + num2;
	}
}
 
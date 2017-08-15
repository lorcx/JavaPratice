package design_model.interpreter; 
/** 
 * @Description: 
 * @Create on: 2015-2-28 上午11:24:21
 * @Author:李欣
 * @Version:1.0
 */
public class Plus implements Expression {

	public int interpret(Context context) {
		return context.getNum1() + context.getNum2();
	}

}
 
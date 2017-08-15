package design_model.interpreter; 
/** 
 * @Description: 
 * @Create on: 2015-2-28 上午11:27:05
 * @Author:李欣
 * @Version:1.0
 */
public class InterpreterTest {
	public static void main(String[] args) {
		Context context = new Context(3,6);
		Plus plus = new Plus();
		int result = plus.interpret(context);
		System.out.println(result);
	}
}
 
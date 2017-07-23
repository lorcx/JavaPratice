package design_model.State; 
/** 
 * @Description: 
 * @Create on: 2015-2-27 下午05:38:38
 * @Author:李欣
 * @Version:1.0
 */
public class StateText {
	public static void main(String[] args) {
		State state = new State();
		Context context = new Context(state);
		
		state.setValue("abc");
		context.method();
		
		state.setValue("sdf");
		context.method();
	}
}
 
package design_model.State; 
/** 
 * @Description: 状态切换类
 * @Create on: 2015-2-27 下午05:38:19
 * @Author:李欣
 * @Version:1.0
 */
public class Context {
	private State state;
	
	public Context(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public void method(){
		if(getState().getValue().equals("abc")){
			state.method1();
		}else{
			state.method2();
		}
	}
	
	
	
}
 
package design_model.Chain_of_Responsibility; 
/** 
 * @Description: 
 * @Create on: 2015-2-27 下午03:59:12
 * @Author:李欣
 * @Version:1.0
 */
public abstract class AbstractHandler {
	private Handler handler;

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
}
 
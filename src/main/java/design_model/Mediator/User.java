package design_model.Mediator; 
/** 
 * @Description: 
 * @Create on: 2015-2-28 上午10:43:38
 * @Author:李欣
 * @Version:1.0
 */
public abstract class User {
	private Mediator mediator;
	
	public User(Mediator mediator) {
		this.mediator = mediator; 
	}
	
	public Mediator getMediator() {
		return mediator;
	}
	
	public abstract void work();
}
 
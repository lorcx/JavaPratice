package design_model.Mediator; 
/** 
 * @Description: 
 * @Create on: 2015-2-28 上午10:47:39
 * @Author:李欣
 * @Version:1.0
 */
public class MyMediator implements Mediator{
	private User user1;
	private User user2;
	
	public void createMediator() {
		user1 = new User1(this);
		user2 = new User2(this);
	}

	public void workAll() {
		user1.work();
		user2.work();
		
	}

}
 
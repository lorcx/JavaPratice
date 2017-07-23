package design_model.Mediator; 
/** 
 * @Description: 
 * @Create on: 2015-2-28 上午10:48:07
 * @Author:李欣
 * @Version:1.0
 */
public class User2 extends User{

	public User2(Mediator mediator) {
		super(mediator);
	}

	public void work() {
		System.out.println("user2. exe");		
	}

}
 
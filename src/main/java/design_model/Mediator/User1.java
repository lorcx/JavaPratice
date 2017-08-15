package design_model.Mediator; 
/** 
 * @Description: 
 * @Create on: 2015-2-28 上午10:47:59
 * @Author:李欣
 * @Version:1.0
 */
public class User1 extends User{

	public User1(Mediator mediator) {
		super(mediator);
	}

	public void work() {
		System.out.println("user1.exe");
		
	}

}
 
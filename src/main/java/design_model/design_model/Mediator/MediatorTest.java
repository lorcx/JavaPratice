package design_model.Mediator; 
/** 
 * @Description: 
 * @Create on: 2015-2-28 上午10:54:18
 * @Author:李欣
 * @Version:1.0
 */
public class MediatorTest {
	public static void main(String[] args) {
 		Mediator mediator = new MyMediator();
		mediator.createMediator();
		mediator.workAll();
	}
}
 
package design_model.factory.simple; 
/** 
 * @Description: 
 * @Create on: 2015-2-26 上午09:59:57
 * @Author:李欣
 * @Version:1.0
 */
public class SimpleTest {
	public static void main(String[] args) {
		SenderFactory factory  = new SenderFactory();
		Sender sender = factory.send("sms");
		sender.Send();
	}
}
 
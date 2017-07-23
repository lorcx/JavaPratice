package design_model.factory.duoge; 
/** 
 * @Description: 
 * @Create on: 2015-2-26 上午10:04:33
 * @Author:李欣
 * @Version:1.0
 */
public class duogeTest {
	public static void main(String[] args) {
		SenderFactory factory = new SenderFactory();
		Sender sender = factory.mailSend();
		sender.Send();
	}
}
 
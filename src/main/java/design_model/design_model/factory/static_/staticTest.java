package design_model.factory.static_; 
/** 
 * @Description: 静态工厂
 * @Create on: 2015-2-26 上午10:04:33
 * @Author:李欣
 * @Version:1.0
 */
public class staticTest {
	public static void main(String[] args) {
		Sender sender = SenderFactory.mailSend();
		sender.Send();
	}
}
 
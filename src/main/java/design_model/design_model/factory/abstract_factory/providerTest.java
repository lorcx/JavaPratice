package design_model.factory.abstract_factory; 
/** 
 * @Description: 
 * @Create on: 2015-2-26 上午10:27:31
 * @Author:李欣
 * @Version:1.0
 */
public class providerTest {
	public static void main(String[] args) {
		Provider provider = new smsFactory();
		Sender sender = provider.send();
		sender.Send();
	}
}
 
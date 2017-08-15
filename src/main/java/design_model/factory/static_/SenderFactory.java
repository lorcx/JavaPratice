package design_model.factory.static_;

/**
 * @Description:
 * @Create on: 2015-2-26 上午09:56:58
 * @Author:李欣
 * @Version:1.0
 */
public class SenderFactory {
	public static Sender smsSend() {
		return new SmsSender();
	}
	
	public static Sender mailSend(){
		return new MailSender();
	}
}

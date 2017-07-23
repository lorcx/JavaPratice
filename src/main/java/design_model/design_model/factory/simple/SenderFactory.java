package design_model.factory.simple;

/**
 * @Description:
 * @Create on: 2015-2-26 上午09:56:58
 * @Author:李欣
 * @Version:1.0
 */
public class SenderFactory {
	public Sender send(String type) {
		if(type.equals("mail")){
			return new MailSender();
		}else if(type.equals("sms")){
			return new SmsSender();
		}else{
			return null;
		}
	}
}

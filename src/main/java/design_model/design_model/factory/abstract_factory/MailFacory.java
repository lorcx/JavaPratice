package design_model.factory.abstract_factory; 



/** 
 * @Description: 
 * @Create on: 2015-2-26 上午10:20:16
 * @Author:李欣
 * @Version:1.0
 */
public class MailFacory implements Provider {

	public Sender send() {
		return new MailSender();
	}

	

}
 
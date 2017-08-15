package design_model.factory.abstract_factory; 


/** 
 * @Description: 
 * @Create on: 2015-2-26 上午10:21:46
 * @Author:李欣
 * @Version:1.0
 */
public class smsFactory implements Provider{

	public Sender send() {
		return new SmsSender();
	}

}
 
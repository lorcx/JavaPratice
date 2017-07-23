package design_model.builder; 

import java.util.ArrayList;
import java.util.List;

/** 
 * @Description: 建造者模式
 * @Create on: 2015-2-26 下午01:43:29
 * @Author:李欣
 * @Version:1.0
 */
public class Builder {
	private List<Sender> list = new ArrayList<Sender>();
	
	public void produceMail(int count){
		for (int i = 0; i < count; i++) {
			list.add(new MailSender());
		}
	}
	
	public void produceSms(int count){
		for (int i = 0; i < count; i++) {
			list.add(new SmsSender());
		}
	}
}
 
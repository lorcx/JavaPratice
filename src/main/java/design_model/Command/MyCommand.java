package design_model.Command; 
/** 
 * @Description: 
 * @Create on: 2015-2-27 下午04:38:13
 * @Author:李欣
 * @Version:1.0
 */
public class MyCommand implements Command{
	
	private receiver receiver;
	
	public MyCommand(receiver receiver) {
		this.receiver = receiver;
	}
	/**
	 * 执行
	 */
	public void exe() {
		receiver.action();
	}

}
 
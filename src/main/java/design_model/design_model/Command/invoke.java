package design_model.Command; 
/** 
 * @Description: 司令
 * @Create on: 2015-2-27 下午04:38:41
 * @Author:李欣
 * @Version:1.0
 */
public class invoke {
	
	private Command command;
	
	public invoke(Command command) {
		this.command = command;
	}
	/**
	 * 司令下命令
	 */
	public void action(){
		command.exe();
	}
}
 
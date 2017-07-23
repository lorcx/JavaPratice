package design_model.Command; 
/** 
 * @Description: 
 * @Create on: 2015-2-27 下午04:50:18
 * @Author:李欣
 * @Version:1.0
 */
public class CommandTest {
	public static void main(String[] args) {
		//创建士兵
		receiver receiver = new receiver();
		//创建命令
		Command command = new MyCommand(receiver);
		//创建司令
		invoke invoke = new invoke(command);
		//司令下命令
		invoke.action();
	}
}
 
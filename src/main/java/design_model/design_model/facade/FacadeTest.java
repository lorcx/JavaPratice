package design_model.facade; 
/** 
 * @Description: 
 * @Create on: 2015-2-26 下午04:45:05
 * @Author:李欣
 * @Version:1.0
 */
public class FacadeTest {
	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.startUp();
		computer.shutDown();
	}
}
 
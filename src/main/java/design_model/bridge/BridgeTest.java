package design_model.bridge; 
/** 
 * @Description: 
 * @Create on: 2015-2-26 下午05:11:07
 * @Author:李欣
 * @Version:1.0
 */
public class BridgeTest {
	public static void main(String[] args) {
		Bridge bridge = new MyBridge();
		bridge.setSource(new Source1());
		bridge.method();
		
		bridge.setSource(new Source2());
		bridge.method();
	}
}
 
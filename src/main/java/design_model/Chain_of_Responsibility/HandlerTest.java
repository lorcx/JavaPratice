package design_model.Chain_of_Responsibility; 
/** 
 * @Description: 
 * @Create on: 2015-2-27 下午04:04:19
 * @Author:李欣
 * @Version:1.0
 */
public class HandlerTest {
	public static void main(String[] args) {
		MyHandler m1 = new MyHandler("h1");
		MyHandler m2 = new MyHandler("h2");
		MyHandler m3 = new MyHandler("h3");
		
		m1.setHandler(m2);
		m2.setHandler(m3);
		m1.operator();
		
		//递归调用m1 → m2 → m3
	}
}
 
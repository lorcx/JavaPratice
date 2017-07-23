package design_model.State; 
/** 
 * @Description: 
 * @Create on: 2015-2-27 下午05:38:26
 * @Author:李欣
 * @Version:1.0
 */
public class State {
	private String value;
	
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public void method1(){
		System.out.println("method1");
	}
	
	public void method2(){
		System.out.println("method2");
	}
}
 
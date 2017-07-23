package design_model.memento; 
/** 
 * @Description: 备忘录类
 * @Create on: 2015-2-27 下午05:08:58
 * @Author:李欣
 * @Version:1.0
 */
public class Memento {
	private String value;

	public Memento(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
 
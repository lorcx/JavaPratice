package design_model.memento; 
/** 
 * @Description: 原始类
 * @Create on: 2015-2-27 下午05:08:20
 * @Author:李欣
 * @Version:1.0
 */
public class Original {
	private String value;
	
	public Original(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 创建备忘录
	 */
	public Memento createMemento(){
		return new Memento(getValue());
	}
	/**
	 * 恢复备忘录
	 * @param memento
	 */
	public void restoreMemento(Memento memento){
		this.value = memento.getValue();
	}
}
 
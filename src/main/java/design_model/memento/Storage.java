package design_model.memento; 
/** 
 * @Description: 存储备忘录类
 * @Create on: 2015-2-27 下午05:10:35
 * @Author:李欣
 * @Version:1.0
 */
public class Storage {
	private Memento memento;
	public Storage(Memento memento) {
		this.memento = memento;
	}
	public Memento getMemento() {
		return memento;
	}
	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
}
 
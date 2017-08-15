package design_model.memento; 
/** 
 * @Description: 备忘录类像是原始类的副本
 * @Create on: 2015-2-27 下午05:18:40
 * @Author:李欣
 * @Version:1.0
 */
public class MementoTest {
	public static void main(String[] args) {
		Original original = new Original("apple");
		System.out.println("备忘前"+original.getValue());
		//创建备忘录
		Memento memento = original.createMemento();
		Storage storage = new Storage(memento);
		original.setValue("milk");
		System.out.println("修改后"+original.getValue());
		//恢复备忘录
		original.restoreMemento(storage.getMemento());
		System.out.println("回复后"+original.getValue());
		
	}
}
 
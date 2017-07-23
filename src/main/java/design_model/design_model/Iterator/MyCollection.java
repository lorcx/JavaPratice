package design_model.Iterator; 
/** 
 * @Description: 
 * @Create on: 2015-2-27 下午03:18:17
 * @Author:李欣
 * @Version:1.0
 */
public class MyCollection implements Collection{
	public String string[] = {"A","B","C","D","E"};  
	
	public Object get(int i) {
		return string[i];
	}

	public Iterator iterator() {
		return new MyIterator(this);
	}

	public int size() {
		return string.length;
	}

}
 
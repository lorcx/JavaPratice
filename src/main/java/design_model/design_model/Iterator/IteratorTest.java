package design_model.Iterator; 
/** 
 * @Description: 
 * @Create on: 2015-2-27 下午03:47:56
 * @Author:李欣
 * @Version:1.0
 */
public class IteratorTest {
	public static void main(String[] args) {
		Collection collection = new MyCollection();
		Iterator iterator = collection.iterator();
		while(iterator.hashNext()){
			System.out.println(iterator.next());
		}
	}
}
 
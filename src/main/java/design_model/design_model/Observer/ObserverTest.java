package design_model.Observer; 
/** 
 * @Description: 
 * @Create on: 2015-2-27 上午11:40:20
 * @Author:李欣
 * @Version:1.0
 */
public class ObserverTest {
	public static void main(String[] args) {
		Subject subject = new MySubject();
		subject.add(new ObserverImpl1());
		subject.add(new ObserverImpl2());
		subject.operation();
	}
}
 
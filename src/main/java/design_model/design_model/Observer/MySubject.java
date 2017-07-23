package design_model.Observer; 
/** 
 * @Description: 
 * @Create on: 2015-2-27 下午02:38:08
 * @Author:李欣
 * @Version:1.0
 */
public class MySubject extends AbstractObserver{
	public void operation() {
	    System.out.println("update self!");  
		notifyObserver();
	}
}
 
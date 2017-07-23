package design_model.Observer; 

import java.util.Enumeration;
import java.util.Vector;

/** 
 * @Description: 
 * @Create on: 2015-2-27 上午11:32:09
 * @Author:李欣
 * @Version:1.0
 */
public abstract class AbstractObserver implements Subject{
	//private Observer observer = null;
	private Vector<Observer> vector = new Vector<Observer>();
	
	public void add(Observer observer) {
		vector.add(observer);
	}
	public void delete(Observer observer) {
		vector.remove(observer);
	}
	public void notifyObserver() {
		Enumeration<Observer> en = vector.elements();
		while(en.hasMoreElements()){
			en.nextElement().update();
		}
	}
}
 
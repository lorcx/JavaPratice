package design_model.Observer; 
/** 
 * @Description: 
 * @Create on: 2015-2-27 上午11:28:50
 * @Author:李欣
 * @Version:1.0
 */
public interface Subject {
	public void add(Observer observer);
	
	public void delete(Observer observer);
	/**
	 * 通知所有的观察者
	 */
	public void notifyObserver();
	/**
	 * 自身操作
	 */
	public void operation();
	
}
 
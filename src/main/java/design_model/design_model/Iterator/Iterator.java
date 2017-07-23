package design_model.Iterator; 
/** 
 * @Description: 
 * @Create on: 2015-2-27 下午03:15:45
 * @Author:李欣
 * @Version:1.0
 */
public interface Iterator {
	/**
	 * 前移  
	 * @return
	 */
	public Object previous();
	/**
	 * 后移
	 * @return
	 */
	public Object next();
	
	/**
	 * 取得第一个元素  
	 * @return
	 */
	public Object first();
	
	
	public boolean hashNext();
}
 
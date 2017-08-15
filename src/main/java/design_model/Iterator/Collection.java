package design_model.Iterator; 


/** 
 * @Description: 
 * @Create on: 2015-2-27 下午03:16:03
 * @Author:李欣
 * @Version:1.0
 */
public interface Collection {
	/**
	 * 获取迭代器
	 * @return
	 */
	public Iterator iterator();
	 /*取得集合元素*/  
	public Object get(int i);
	  /*取得集合大小*/  
	public int size();
	
	
}
 
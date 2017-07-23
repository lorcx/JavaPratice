package design_model.Iterator; 
/** 
 * @Description: 
 * @Create on: 2015-2-27 下午03:14:58
 * @Author:李欣
 * @Version:1.0
 */
public class MyIterator implements Iterator{
	
	private Collection collection;
	private int pos = -1;  //指针
	
	public MyIterator(Collection collection) {
		this.collection = collection;
	}
	/**
	 * 取得第一个元素  
	 * @return
	 */
	public Object first() {
		pos = 0;
		return collection.get(pos);
	}


	/**
	 * 后移
	 * @return
	 */
	public Object next() {
		if(pos < collection.size()-1){
			pos++;
		}
		return collection.get(pos);
	}
	/**
	 * 前移  
	 * @return
	 */
	public Object previous() {
		if(pos > 0){
			pos--;
		}
		return collection.get(pos);
	}
	/**
	 * 判断一个是否存在
	 */
	public boolean hashNext() {
		if(pos < collection.size()-1){
			return true;
		}else{
			return false;
		}
	}

}
 
package design_model.proxy.jingtai; 
/** 
 * @Description: 代理
 * @Create on: 2015-2-16 下午04:34:51
 * @Author:李欣
 * @Version:1.0
 */
public class CountProxy implements Count {
	private CountImpl countImpl;
	public CountProxy(CountImpl countImpl){
		this.countImpl = countImpl;
	}
	
	public void queryCount() {
		System.out.println("事物的处理前");
		countImpl.queryCount();	
		System.out.println("事物的处理后");
	}

	public void updateCount() {
		System.out.println("事物的处理前");
		countImpl.updateCount();
		System.out.println("事物的处理后");
	}

}
 
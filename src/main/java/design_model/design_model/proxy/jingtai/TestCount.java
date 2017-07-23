package design_model.proxy.jingtai; 
/** 
 * @Description: 
 * @Create on: 2015-2-16 下午04:37:22
 * @Author:李欣
 * @Version:1.0
 */
public class TestCount {
	public static void main(String[] args) {
		/**
		 * 静�?代理
		 */
		CountImpl impl = new CountImpl();
		CountProxy proxy = new CountProxy(impl);
		proxy.queryCount();
		proxy.updateCount();
		
	}
}
 
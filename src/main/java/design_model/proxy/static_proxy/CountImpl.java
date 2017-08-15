package design_model.proxy.static_proxy; 
/** 
 * @Description: 账户接口实现
 * @Create on: 2015-2-16 下午04:28:18
 * @Author:李欣
 * @Version:1.0
 */
public class CountImpl implements Count{

	public void queryCount() {
		System.out.println("查询账户");
		
	}

	public void updateCount() {
		System.out.println("修改账户");
		
	}
}
 
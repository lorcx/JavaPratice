package design_model.proxy.jingtai; 
/** 
 * @Description: δ»£ηη±?
 * @Create on: 2015-2-16 δΈε04:34:51
 * @Author:ζζ¬£
 * @Version:1.0
 */
public class CountProxy implements Count {
	private CountImpl countImpl;
	public CountProxy(CountImpl countImpl){
		this.countImpl = countImpl;
	}
	
	public void queryCount() {
		System.out.println("δΊη©ηε€ηε");
		countImpl.queryCount();	
		System.out.println("δΊη©ηε€ηε");
	}

	public void updateCount() {
		System.out.println("δΊη©ηε€ηε");
		countImpl.updateCount();
		System.out.println("δΊη©ηε€ηε");
	}

}
 
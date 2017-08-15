package design_model.proxy.cblib; 
/** 
 * @Description: 
 * @Create on: 2015-2-25 上午09:53:18
 * @Author:李欣
 * @Version:1.0
 */
public class TestCglib {
	public static void main(String[] args) {
		BookFacadeProxy proxy = new BookFacadeProxy();
		BookFacadeImpl impl = (BookFacadeImpl) proxy.getInstance(new BookFacadeImpl());
		impl.addBook();
	}
}
 
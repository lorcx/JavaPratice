package design_model.proxy.dynamic; 
/** 
 * @Description: jdk
 * @Create on: 2015-2-16 下午05:15:22
 * @Author:李欣
 * @Version:1.0
 */
public class BookTtest {
	public static void main(String[] args) {
		
		BookFacadeProxy bookFacadeProxy = new BookFacadeProxy();
		BookFacade bookFacade  = (BookFacade)bookFacadeProxy.bind( new BookFacadeImpl());
		bookFacade.addBook();
		
	}
}
 
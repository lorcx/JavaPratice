package se.se.issue;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 * 遍历HashMap的最佳方法
 * @author dell
 *
 */
public class PushHashMap {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("test", "test_value");
		/*方式一*/
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			System.out.println(pair.getKey() + " " + pair.getValue());
		}
		/*方式二*/
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
	}
}

package annotation;
import java.lang.Deprecated;import java.lang.String;import java.lang.System; /**
 * Deprecated不赞成的
 * @author dell
 *
 */
public class ADeprecated {
	public static void main(String[] args) {
		ADeprecated t = new ADeprecated();				
		t.printStr("@deprecated测试");		
	}
	
	
	@Deprecated
	private void printStr(String string) {
		System.out.println(string);
	}
}

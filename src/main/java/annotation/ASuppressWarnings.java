package annotation;

import java.lang.String;import java.lang.SuppressWarnings;import java.lang.System;import java.util.HashMap;
import java.util.Map;

public class ASuppressWarnings {
	
	@SuppressWarnings({"unchecked","unused"})
	public static void main(String[] args) {
		Map map = new HashMap();
		System.out.println("@SuppressWarnings的使用");
	}
	
	
}

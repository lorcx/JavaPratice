package se.se;

import java.util.regex.Pattern;

public class zhengze {
	public static void main(String[] args) {
		String str = "12";
		//java�е�����
		String regex = "\\d?";
		boolean b =  Pattern.matches(regex, str);
		System.out.println(b);
	}
}

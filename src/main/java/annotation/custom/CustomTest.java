package annotation.custom;

import java.lang.annotation.Annotation;

public class CustomTest {
	public static void main(String[] args) {
		UseAnnotation ua = new UseAnnotation();
		try {
			Annotation[] at = ua.getClass().getMethod("say").getAnnotations();
			for (Annotation an : at) {
				if(an instanceof CustomAnnocation){
					System.out.println(an);
					System.out.println(((CustomAnnocation)an).name());
					System.out.println(((CustomAnnocation)an).age());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

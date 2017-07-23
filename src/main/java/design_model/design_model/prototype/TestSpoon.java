package design_model.prototype;

public class TestSpoon {
	public static void main(String[] args) {
		AbstractSpoon spoon = new SoupSpoon();
		AbstractSpoon spoon2 = (AbstractSpoon) spoon.clone();
	}
}

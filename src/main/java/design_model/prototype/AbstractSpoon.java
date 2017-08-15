package design_model.prototype;
/**
 * ԭ��ģʽ
 * @author dell
 *
 */
public abstract class AbstractSpoon {
	public String spoonName;

	public String getSpoonName() {
		return spoonName;
	}

	public void setSpoonName(String spoonName) {
		this.spoonName = spoonName;
	}
	
	public Object clone(){
		Object obj = null;
		try {
			super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}
}

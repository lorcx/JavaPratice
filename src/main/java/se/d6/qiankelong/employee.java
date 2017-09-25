package se.d6.qiankelong;
/**
 *
 *�����ˣ�lixin     
 *����ʱ�䣺2014-12-15 ����11:46:12
 *������
 */
public class employee implements Cloneable{
	private String name;
	private int age;
	private Address address;
	
	
	public employee(String name, int age, Address address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("����"+name+"\n");
		sb.append("����"+age+"\n");
		sb.append("��ַ"+address+"\n");
		return sb.toString();
	}
	
	public employee clone(){
		employee e = null;
		try {
			e = (employee) super.clone();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}
		return e;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}

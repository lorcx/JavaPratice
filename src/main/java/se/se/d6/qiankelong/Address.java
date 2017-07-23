package se.se.d6.qiankelong;
/**
 *
 *�����ˣ�lixin     
 *����ʱ�䣺2014-12-15 ����11:45:07
 *������
 */
public class Address {
	private String state;//���ڹ���
	private String province;//��ʾԱ�����ڵ�ʡ
	private String city;//����
	public Address(String state,String province, String city){
		this.state = state;
		this.province = province;
		this.city = city;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("����:"+state+"\n");
		sb.append("ʡ"+province+"\n");
		sb.append("����"+city+"\n");
		return sb.toString();
	}
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}

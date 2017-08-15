package design_model.prototype; 

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/** 
 * @Description: 浅克隆he深克隆
 * @Create on: 2015-2-26 下午01:57:22
 * @Author:李欣
 * @Version:1.0
 */
public class Prototype1 implements Cloneable,Serializable{
	
	private static final long serialVersionUID = 1L;
	private serializableObject ojb;
	private String string;
	
	public serializableObject getOjb() {
		return ojb;
	}
	public void setOjb(serializableObject ojb) {
		this.ojb = ojb;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}


	//浅克隆
	protected Object clone() throws CloneNotSupportedException {
		Prototype1 prot = (Prototype1) super.clone();//重点
		return prot;
	}
	
	//深克隆
	public Object deepClone() throws IOException, ClassNotFoundException{
		/* 写入当前对象的二进制流 */  
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bao);
		oos.writeObject(this);
		/* 读出二进制流产生的新对象 */
		ByteArrayInputStream bis =	new ByteArrayInputStream(bao.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
		
	}
	
	public class serializableObject{
		
	}
	
	
	
	
	
	
}
 
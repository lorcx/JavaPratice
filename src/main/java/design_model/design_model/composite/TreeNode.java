package design_model.composite; 

import java.util.Enumeration;
import java.util.Vector;

/** 
 * @Description: 
 * @Create on: 2015-2-27 上午09:26:57
 * @Author:李欣
 * @Version:1.0
 */
public class TreeNode {
	private String name;//节点名字
	private TreeNode parent;//父节点
	private Vector<TreeNode> children = new Vector<TreeNode>();//子节点
	
	public TreeNode(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TreeNode getParent() {
		return parent;
	}
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	public Vector<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(Vector<TreeNode> children) {
		this.children = children;
	}
	//增加
	public void add(TreeNode node){
		children.add(node);
	}
	//shanchu
	public void remove(TreeNode node){
		children.remove(node);
		
	}
	
	//获取
	public Enumeration<TreeNode> getElement(){
		return children.elements();
	}
	
}
 
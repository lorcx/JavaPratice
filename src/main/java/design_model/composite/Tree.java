package design_model.composite; 
/** 
 * @Description: 
 * @Create on: 2015-2-27 上午09:35:26
 * @Author:李欣
 * @Version:1.0
 */
public class Tree {
	private TreeNode root = null;
	
	public Tree(String name) {
		root = new TreeNode(name);
	}
	public static void main(String[] args) {
		//通过构造方法给root节点赋值
		Tree tree = new Tree("a");
		//创建节点b
		TreeNode b = new TreeNode("b");
		//创建节点c
		TreeNode c = new TreeNode("c");
		//添加子节点
		b.add(c);
		//根节点添加子节点
		tree.root.add(b);
		System.out.println("tianjia finish");
		
	}
}
 
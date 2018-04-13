class Link  //定义一个链表类
{
	private class Node  //定义内部节点类
	{
		private String data;  //定义数据
		private Node next;  //定义下一个指向（引用关系）
		public Node(String data) {
			this.data = data;
		}

		public void addNode(Node newNode) {
			if(this.next == null) {
				this.next = newNode;
			} else {
				this.next.addNode(newNode);
			}
		}
	}

	private Node root;  //定义头结点
	public void add(String data) {  //添加数据
		if(data == null) {
			return ;
		}	
		Node newNode  = new Node(data);  //将数据转化为Node类型
		if(this.root == null) {
			this.root = newNode;
		} else {
			this.root.addNode(newNode);
		}
	}
}

public class Test07
{
	public static void main(String[] args) {
		Link link = new Link();
		link.add("Hello");
		link.add("feifei");
		link.add("wwwww");
		link.add(null);
	}
}

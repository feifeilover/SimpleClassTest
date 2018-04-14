class Link
{
	private class Node 
	{
		private String data;  //定义数据
		private Node next;  //定义下一个指向
		public Node(String data) {
			this.data = data;
		}

		public void addNode(Node newNode) {  //链表数据添加
			if(this.next == null) {
				this.next = newNode;
			} else {
				this.next.addNode(newNode);
			}
		}

		public void toArrayNode() {  //链表数据返回数组取出
			Link.this.retArray[Link.this.foot ++ ] = this.data;
			if(this.next != null) {
				this.next.toArrayNode();
			}
		}
	}

	private Node root;  //定义头结点
	private int count = 0;  //定义一个角标
	private int foot = 0;  //定义一个步长
	private String[] retArray;  //返回数组
	public void add(String data) {  //添加数据
		if(data == null) {
			return ;
		}
		Node newNode = new Node(data);  //将数据data转化为Node型数据
		if(this.root == null) {
			this.root = newNode;
		} else {
			this.root.addNode(newNode);
		}
		this.count ++ ;
	}

	public String[] toArray() {  //链表数据返回数组取出
		if(this.root == null) {
			return null;
		}
		this.foot = 0;
		this.retArray = new String[this.count];
		this.root.toArrayNode();
		return this.retArray;
	}
}

public class Test07
{
	public static void main(String[] args) {
		Link link = new Link();
		link.add("Hello");
		link.add("wewww");
		link.add("feifei");
		//link.add(null);
		String[] data = link.toArray();
		for(int i=0;i<data.length;i++) {
			System.out.println(data[i]);
		}
	}
}

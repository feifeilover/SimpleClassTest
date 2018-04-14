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

		public boolean containsNode(String data) {  //查询链表数据
			if(data.equals(this.data)) {
				return true;
			} else {
				if(this.next != null) {
					return this.next.containsNode(data);
				} else {
					return false;
				}
			}
		}

		public String getNode(int index) {  //根据索引取得数据
			if(Link.this.foot ++ == index)  {
				return this.data;
			} else {
				return this.next.getNode(index);
			}
		}

		public void setNode(int index,String data) {
			if(data.equals(this.data)) {
				this.data = data;
			} else {
				this.next.setNode(index,data);
			}
		}

		public void removeNode(Node previous,String data) {  //删除非头结点的数据
			if(data.equals(this.data)) {
				previous.next = this.next;
			} else {
				this.next.removeNode(this,data);
			}
		}
	}

	private Node root;  //定义头结点
	private int count = 0;  //定义一个角标
	private int foot = 0;  //定义步长
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
		this.count ++ ;
	}
	public int size() {  //定义长度方法
		return this.count;
	}

	public boolean isEmpty() {  //添加判空方法
		return this.count == 0;
	}

	public boolean contains(String data) {  //查询链表数据
		if(data == null || this.root == null) {
			return false;  
		}
		else {
			return this.root.containsNode(data);
		}
	}

	public String get(int index) {  //根据索引取得数据
		if(index > this.count) {
			return null;
		} 
		this.foot = 0;  //步长归零
		return this.root.getNode(index);
	}

	public void set(int index,String data) {  //修改数据
		if(index > this.count) {
			return ;
		}
		this.foot = 0;  //步长归零
		this.root.setNode(index,data);
	}

	public void remove(String data) {  //删除头节点数据
		if(this.contains(data)) {
			if(data.equals(this.root.data)) {
				this.root = this.root.next;
			} else {
				this.root.removeNode(this.root,data);
			}
		}
		this.count -- ;
	}

}

public class Test07
{
	public static void main(String[] args) {
		Link link = new Link();
		System.out.println(link.size() + "," + link.isEmpty());
		link.add("Hello");
		link.add("feifei");
		link.add("wwwww");
		link.remove("feifei");
	//	link.add(null);
		System.out.println(link.get(1));  //根据索引取数据   结果为Hello
	//	System.out.println(link.size() + "," + link.isEmpty());
	//	System.out.println(link.contains("feifei"));    //结果为true
	//	System.out.println(link.contains("eeee"));     //结果为false
	}
}

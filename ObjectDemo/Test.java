//完善链表

class Link
{
	private class Node
	{
		private Object data;  //保存数据
		private Node next;  //定义下一个指向
		public Node(Object data) {
			this.data = data;
		}

		public void addNode(Node newNode) {  //添加数据
			if(this.next == null) {
				this.next = newNode;
			} else {
				this.next.addNode(newNode);
			}
		}

		public Object getNode(int index) {  //根据索引取得数据
			if(Link.this.foot ++ == index) {
				return this.data;
			} else {
				return this.next.getNode(index);
			}
		}

		public boolean containsNode(Object data) {  //查询数据
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

		public void setNode(int index,Object data) {  //重新设置数据
			if(Link.this.foot ++ == index) {
				this.data = data;
			} else {
				this.next.setNode(index,data);
			}
		}

		public void removeNode(Node previous,Object data) {  //删除非头结点数据
			if(data.equals(this.data)) {
				previous.next = this.next;
			} else {
				this.next.removeNode(this,data);
			}
		}

		public void toArrayNode() {   //返回数组
			Link.this.retArray[Link.this.foot ++ ] = this.data;
			if(this.next != null) {
				this.next.toArrayNode();
			}
		}
	}

	private Node root;  //定义一个头节点
	private int count = 0;  //定义一个角标
	private int foot = 0;  //定义一个步长
	private Object[] retArray;  //返回的数组
	public void add(Object data) {  //添加数据
		if(data == null) {
			return ;
		}
		Node newNode = new Node(data);  //将data数据转换为Node类型
		if(this.root == null) {
			this.root = newNode;
		} else {
			this.root.addNode(newNode);
		}
		this.count ++ ;
	}
	public int size() {  //取得保存的数据量
		return this.count;
	}

	public boolean isEmpty() {  //判空 
		return this.count == 0;
	}

	public Object get(int index) {  //根据索引取得数据
		if(index > this.count) {
			return null;
		}
		this.foot = 0;  //步长归零
		return this.root.getNode(index);
	}

	public boolean contains(Object data) {  //查询数据
		if(data == null || this.root == null) {
			return false;
		}
		return this.root.containsNode(data);
	}

	public void set(int index,Object data) {  //重新设置数据
		if(index > this.count) {
			return ;
		}
		this.foot = 0;
		this.root.setNode(index,data);
	}

	public void remove(Object data) {  //删除头结点的数据
		if(this.contains(data)) {
			if(data.equals(this.root.data)) {
				this.root = this.root.next;
			} else {
				this.root.removeNode(this.root,data);
			}
			this.count -- ;
		}
	}

	public Object[] toArray() {  //返回数组
		if(this.root == null) {
			return null;
		}
		this.foot = 0;
		this.retArray = new Object[this.count];
		this.root.toArrayNode();
		return this.retArray;
	}
}

public class ProxyDemo
{
	public static void main(String[] args) {
		Link all = new Link();
		all.add("A");
		all.add("B");
		all.add("C");
		all.remove("A");
		Object[] data = all.toArray();
		for(int i=0;i<data.length;i++) {
			System.out.println(data[i]);
		}
	}
}

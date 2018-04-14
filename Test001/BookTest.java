class Book
{
	private String title;  //标题
	private double price;  //价格
	public Book(String title,double price) {
		this.title = title;
		this.price = price;
	}

	public String getInfo() {
		return "图书名称:" + this.title + ",图书价格:" + this.price;
	}

	public boolean compare(Book book) {
		if(book == null) {
			return false;
		}
		if(this == book) {
			return true;
		}
		if(this.title.equals(book.title) && this.price == book.price) {
			return true;
		}
		return false;
	}
}

class Link
{
	private class Node
	{
		private Book data;  //定义数据
		private Node next;  //定义下一个指向

		public Node(Book data) {
			this.data = data;
		}

		public void addNode(Node newNode) {  //添加数据
			if(this.next == null) {
				this.next = newNode;
			} else {
				this.next.addNode(newNode);
			}
		}

		public boolean containsNode(Book data) {  //查询链表数据
			if(data.compare(this.data)) {
				return true;
			} else {
				if(this.next != null) {
					return this.next.containsNode(data);
				} else {
					return false;
				}
			}
		}

		public Book getNode(int index) {  //根据索引取得链表数据
			if(Link.this.foot ++ == index) {
				return this.data;
			} else {
				return this.next.getNode(index);
			}
		}

		public void removeNode(Node previous,Book data) {  //删除链表数据
			if(data.compare(this.data)) {
				previous.next = this.next;
			} else {
				this.next.removeNode(this,data);
			}
		}

		public void toArrayNode() {
			Link.this.retArray[Link.this.foot ++ ] = this.data;
			if(this.next != null) {
				this.next.toArrayNode();
			}
		}
	}

	private Node root;  //定义头指针
	private int count = 0;  //定义一个角标
	private int foot = 0;  //定义一个步长
	private Book[] retArray;  //返回数组
	public void add(Book data) {  //添加数据
		if(data == null) {
			return ;
		}
		Node newNode = new Node(data);  //将data数据定义为书的类型
		if(this.root == null) {
			this.root = newNode;
		} else {
			this.root.addNode(newNode);
		}
		this.count ++ ;
	}

	public boolean contains(Book data) {  //查询数据
		if(data == null || this.root == null) {
			return false;
		} else {
			return this.root.containsNode(data);
		}
	}

	public Book get(int index) {  //根据索引取得链表数据
		if(index > this.count) {
			return null;
		} 
		this.foot = 0;
		return this.root.getNode(index);
	}

	public void remove(Book data) {  //删除链表数据
		if(this.contains(data)) {
			if(data.compare(this.root.data)) {
				this.root = this.root.next;
			} else {
				this.root.removeNode(this.root,data);
			}
			this.count --;
		}
	}
	
	public Book[] toArray() {  //对象数组返回
		if(this.root == null) {
			return null;
		}
		this.foot = 0;
		this.retArray = new Book[this.count];
		this.root.toArrayNode();
		return this.retArray;
	}
}

public class BookTest
{
	public static void main(String[] args) {
		Link link = new Link();
		link.add(new Book("java开发",99.0));
		link.add(new Book("php开发",89.0));
		link.add(new Book("python开发",79.0));
		System.out.println(link.contains(new Book("php开发",89.0)));
		link.remove(new Book("java开发",99.0));
		Book [] books = link.toArray();
		for(int i=0;i<books.length;i++) {
			System.out.println(books[i].getInfo());
		}

	}
}

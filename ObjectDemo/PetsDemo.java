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

interface Pet  //定义一个宠物的标准
{
	public String getName();  //得到宠物的名字
	public int getAge();  //得到宠物的年龄
}

class PetShop  //定义一个宠物商店
{
	private Link pets = new Link();
	public void add(Pet pet) {  //上架
		this.pets.add(pet);
	}

	public void delete(Pet pet) {  //下架
		this.pets.remove(pet);
	}

	public Link search(String keyWord) {  //模糊查询
		Link result = new Link();
		Object[] obj = this.pets.toArray();
		for(int i=0;i<obj.length;i++) {
			Pet p = (Pet)obj[i];
			if(p.getName().contains(keyWord)) {
				result.add(p);
			}
		}
		return result;
	}
}

class Cat implements Pet
{
	private String name;
	private int age;
	public Cat(String name,int age) {
		this.name = name;
		this.age = age;
	}
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}

		if(obj == null) {
			return false;
		}

		if(!(obj instanceof Cat)) {
			return false;
		}

		Cat c = (Cat) obj;
		if(this.name.equals(c.name) && this.age == c.age) {
			return true;
		}
		return false;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public String toString() {
		return "猫的名字：" + this.name + ",年龄:" + this.age;
	}
}

class Dog implements Pet
{
	private String name;
	private int age;
	public Dog(String name,int age) {
		this.name = name;
		this.age = age;
	}
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(!(obj instanceof Dog)) {
			return false;
		}
		Dog c = (Dog)obj;
		if(this.name.equals(c.name) && this.age == c.age) {
			return true;
		}
		return false;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public String toString() {
		return "狗狗的名字：" + this.name + ",年龄:" + this.age;
	}
}

public class ProxyDemo
{
	public static void main(String[] args) {
		PetShop shop = new PetShop();
		shop.add(new Cat("王猫",12));
		shop.add(new Cat("李猫",12));
		shop.add(new Cat("汤猫",12));
		shop.add(new Dog("王狗",7));
		shop.add(new Cat("李狗",7));
		shop.add(new Cat("汤狗",11));
		Link all = shop.search("王");
		Object [] obj = all.toArray();
		for(int i=0;i<obj.length;i++) {
			System.out.println(obj[i]);
		}
	}
}

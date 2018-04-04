class Item  //父栏目类
{
	private int iid;
	private String name;
	private String note;
        private Submit[] submits; 	//一个父栏目下有多个子栏目
        private Product[] products;    //一个父栏目下有多个商品
	public Item(int iid,String name,String note) {
		this.iid = iid;
		this.name = name;
		this.note = note;
	}

	public void setSubmits(Submit[] submits) {
		this.submits = submits;
	}

	public Submit[] getSubmits() {
		return this.submits;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

	public Product[] getProducts() {
		return this.products;
	}

	public String getInfo() {
		return "栏目编号:" + this.iid + ",栏目名称:" + this.name + ",栏目描述:" + this.note;
	}
}

class Submit  //子栏目类
{
	private int sid;
	private String name;
	private String note;
        private Product[] products;	//一个子类下有多个商品
        private Item item;	//每个子类属于一个父类
	public Submit(int sid,String name,String note) {
		this.sid = sid;
		this.name = name;
		this.note = note;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

	public Product[] getProducts() {
		return this.products;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return this.item;
	}

	public String getInfo() {
		return "子栏目编号:" + this.sid + ",子栏目名称:" + this.name + ",子栏目描述:" + this.note;
	}
}

class Product  //商品类
{
	private int pid;
	private String name;
	private double price;
	private Submit submit;  //每一件商品属于一个子类
	private Item item;  //每一件商品属于一个父类
	public Product(int pid,String name,double price) {
		this.pid = pid;
		this.name = name;
		this.price = price;
	}
	
	public void setSubmit(Submit submit) {
		this.submit = submit;
	}

	public Submit getSubmit() {
		return this.submit;
	}
	
	public void setItem(Item item) {
		this.item = item;
	} 

	public Item getItem() {
		return this.item;
	}

	public String getInfo() {
		return "商品编号:" + this.pid + ",商品名称:" + this.name + ",商品价格:" + this.price;
	}
}

public class TestDemo05
{
	public static void main(String[] args) {
		Item item = new Item(1,"厨房用具","-");
		Submit suba = new Submit(1001,"厨具","-");
		Submit subb = new Submit(1002,"刀具","-");
		Submit subc = new Submit(1003,"餐具","-");
		Product proa = new Product(2001,"蒸锅",500.0);
		Product prob = new Product(2002,"炒锅",300.0);
		Product proc = new Product(2003,"菜刀",10.0);
		Product prod = new Product(2004,"水果刀",9.0);
		Product proe = new Product(2005,"青花瓷",50.0);
		Product prof = new Product(2006,"水晶筷子",40.0);
		item.setSubmits(new Submit[] {suba,subb,subc});  //一个父类有多个子类
		suba.setItem(item);  //一个子类属于一个父类
		subb.setItem(item);
		subc.setItem(item);
		suba.setProducts(new Product[] {proa,prob});  //一个子类下有几个商品
		subb.setProducts(new Product[] {proc,prod});
		subc.setProducts(new Product[] {proe,prof});
		proa.setSubmit(suba);  //一个商品属于一个子类
		prob.setSubmit(suba);
		proc.setSubmit(subb);
		prod.setSubmit(subb);
		proe.setSubmit(subc);
		prof.setSubmit(subc);
		item.setProducts(new Product[] {proa,prob,proc,prod,proe,prof}); //一个父类下有多个商品
		proa.setItem(item);  //一个商品属于一个父类
		prob.setItem(item);
		proc.setItem(item);
		prod.setItem(item);
		proe.setItem(item);
		prof.setItem(item);

		System.out.println(item.getInfo());  //找到父类信息
		for(int i=0;i<item.getSubmits().length;i++) {
			System.out.println("\t|-" + item.getSubmits()[i].getInfo());  //找到父类下的所有子类信息
		}
		System.out.println("*********");
		System.out.println(item.getInfo());  //再次找到父类信息输出
		for(int i=0;i<item.getProducts().length;i++) {
			System.out.println("\t\t|-" + item.getProducts()[i].getInfo());  //从父类找到各个商品信息输出
			System.out.println("\t|-" + item.getProducts()[i].getSubmit().getInfo());  //从各个商品找到所对应的子类信息输出
		}
		System.out.println("==========");
		System.out.println(subb.getInfo());  //找到子类subb类
		for(int i=0;i<subb.getProducts().length;i++) {
			System.out.println("\t|-" + subb.getProducts()[i].getInfo());  //输出subb子类所对应的商品信息
		}
	}
}

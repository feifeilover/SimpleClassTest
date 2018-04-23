interface Person  //接口：核心主题
{
	public void buy();
}

class XiaoMing implements Person  //真实主题
{
	public void buy() {
		System.out.println("我饿了，想要吃饭");
	}
}

class Me implements Person  //代理主题
{
	private Person person;
	public Me(Person person) {
		this.person = person;
	}
	public void buy() {
		System.out.	println("我帮小明买饭");
	}
}

public class ProxyDemo
{
	public static void main(String[] args) {
		Person per = new Me(new XiaoMing());
		per.buy();
	}
}

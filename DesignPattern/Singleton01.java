class Singleton   //单例设计模式(懒汉式)
{
	private static Singleton instance;
	private Singleton() {}
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	public void print() {
		System.out.println("你好哦");
	}
}

public class Demo
{
	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		s.print();
	}
}

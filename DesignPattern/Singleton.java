class Singleton  //单例设计模式(饿汉式)
{
	private static final Singleton INSTANCE = new Singleton();
	private Singleton() {}
	public static Singleton getInstance() {
		return INSTANCE;
	}
	public void print() {
		System.out.println("菲菲你好!");
	}
}

public class Demo
{
	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		s.print();
	}
}

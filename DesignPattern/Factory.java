interface Fruit  //定义一个Fruit接口
{
	public void eat();
}

class Apple implements Fruit
{
	public void eat() {
		System.out.println("****吃苹果");
	}
}

class Banana implements Fruit
{
	public void eat() {
		System.out.println("****吃香蕉");
	}
}

class Orange implements Fruit
{
	public void eat() {
		System.out.println("****吃橘子");
	}
}

class Factory  //定义一个工厂类
{
	public static Fruit getInstance(String className) {
		if("apple".equals(className)) {
			return new Apple();
		} else {
			if("banana".equals(className)) {
				return new Banana();
			} else {
				if("orange".equals(className)) {
					return new Orange();
				} else {
					return null;
				}
			}
		}
	}
}

public class GoChang
{
	public static void main(String[] args) {
		Fruit f = Factory.getInstance("orange");
		f.eat();
	}
}

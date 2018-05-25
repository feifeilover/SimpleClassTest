class Pet { // 宠物
	private String name;
	private int health;
	private int love;

	public Pet(String name, int health, int love) {
		super();
		this.name = name;
		this.health = health;
		this.love = love;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getLove() {
		return love;
	}

	public void setLove(int love) {
		this.love = love;
	}

	public void print() {

	}

	public void eat() {

	}

}

class Dog extends Pet { // 狗
	private String strain;

	public Dog(String name, int health, int love, String strain) {
		super(name, health, love);
		this.strain = strain;
	}

	public String getStrain() {
		return strain;
	}

	public void setStrain(String strain) {
		this.strain = strain;
	}

	public void eat() {
		System.out.println("狗狗吃骨头");
	}

	public void catchingFlyDisc() {
		System.out.println("狗狗玩飞盘游戏");
		this.setHealth(this.getHealth() - 10);
		System.out.println("剩余健康值" + this.getHealth());
		this.setLove(this.getLove() + 5);
		System.out.println("增加后的爱心值" + this.getLove());

	}

	public void print() {
		System.out.println("狗的名字:" + this.getName() + ",健康值" + this.getHealth() + ",爱心" + this.getLove() + ",品种" + this.strain);
	}
}

class Penguin extends Pet {

	public Penguin(String name, int health, int love) {
		super(name, health, love);
		// TODO Auto-generated constructor stub
	}

	public void eat() {
		System.out.println("企鹅不吃东西");
	}

	public void swimming() {
		System.out.println("企鹅玩游泳");
		this.setHealth(this.getHealth() - 10);
		System.out.println("剩余健康值" + this.getHealth());
		this.setLove(this.getLove() + 5);
		System.out.println("增加后的爱心值" + this.getLove());
	}
	
	public void print() {
		System.out.println("企鹅的名字" + this.getName() + ",健康值:" + this.getHealth() + ",爱心" + this.getLove());
	}
}

class Host { // 主人
	private String name;
	private int money;

	public Host(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void feet(Pet pet) {
		if (pet instanceof Dog) {
			//pet = new Dog(null, 0, 0, null);
			System.out.println("主人可以喂养狗");
			pet.eat();
		}
		if (pet instanceof Penguin) {
			//pet = new Penguin(null, 0, 0);
			System.out.println("主人可以喂养企鹅");
			pet.eat();
		}
	}

	public void play(Pet pet) {
		if (pet instanceof Dog) {
			((Dog) pet).catchingFlyDisc();
		}

		if (pet instanceof Penguin) {
			((Penguin) pet).swimming();
		}
	}
}

public class Demo05 {
	public static void main(String[] args) {
		Host host = new Host("张三", 500);
		Pet pet1 = new Dog("小狗狗", 100, 80, "普通狗");
		host.feet(pet1);
		host.play(pet1);
		pet1.print();

		Pet pet2 = new Penguin("小企鹅", 50, 40);
		host.feet(pet2);
		host.play(pet2);
		pet2.print();

	}
}

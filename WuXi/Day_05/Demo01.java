class Employee01 {
	private String name;
	private int birthMonth;

	public Employee01(String name, int birthMonth) {
		super();
		this.name = name;
		this.birthMonth = birthMonth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary(int month) {
		if (birthMonth == month) {
			return 100;
		}
		return 0;
	}
}

class SalariedEmployee01 extends Employee01 {
	private double salary;

	public SalariedEmployee01(String name, int birthMonth, double salary) {
		super(name, birthMonth);
		this.salary = salary;
	}

	@Override
	public double getSalary(int month) {
		// TODO Auto-generated method stub
		return super.getSalary(month) + salary;
	}
}

class HourlyEmployee01 extends Employee01 {
	private double hourSalary;
	private int hour;

	public HourlyEmployee01(String name, int birthMonth, double hourSalary, int hour) {
		super(name, birthMonth);
		this.hourSalary = hourSalary;
		this.hour = hour;
	}

	@Override
	public double getSalary(int month) {
		if (hour > 160) {
			return super.getSalary(month) + (hour - 160) * 1.5 * hourSalary + 160 * hourSalary;
		}
		return super.getSalary(month) + hour * hourSalary;
	}
}

class SalesEmployee01 extends Employee01 {
	private double sales;
	private double pre;

	public SalesEmployee01(String name, int birthMonth, double sales, double pre) {
		super(name, birthMonth);
		this.sales = sales;
		this.pre = pre;
	}

	@Override
	public double getSalary(int month) {
		// TODO Auto-generated method stub
		return super.getSalary(month) + sales * pre;
	}
}

class BasePlusSalesEmployee01 extends SalesEmployee01 {
	private double baseSalary;

	public BasePlusSalesEmployee01(String name, int birthMonth, double sales, double pre, double baseSalary) {
		super(name, birthMonth, sales, pre);
		this.baseSalary = baseSalary;
	}

	@Override
	public double getSalary(int month) {
		// TODO Auto-generated method stub
		return super.getSalary(month) + baseSalary;
	}

}

public class Demo04 {
	public static void main(String[] args) {
		Employee01[] emps = new Employee01[4];
		emps[0] = new SalariedEmployee01("hh", 2, 200);
		emps[1] = new HourlyEmployee01("ttt", 3, 20, 170);
		emps[2] = new SalesEmployee01("qq", 4, 1000, 0.2);
		emps[3] = new BasePlusSalesEmployee01("www", 5, 1000, 0.4, 200);
		for (int i = 0; i < 4; i++) {
			System.out.println(emps[i].getName()+emps[i].getSalary(3));
		}
	}
}

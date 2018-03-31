class Dept
{
	private int deptno;
	private String dname;
	private String loc;
	public Emp[] emps;  //一个部门有多个雇员
	public Dept(int deptno,String dname,String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public void setEmps(Emp[] emps) {
		this.emps = emps;
	}

	public Emp[] getEmps() {
		return this.emps;
	}
	
	public String getInfo() {
		return "部门编号:" + this.deptno + ",部门名称:" + this.dname + ",部门位置:" + this.loc;
	}
}

class Emp
{
	private int empno;
	private String ename;
	private String job;
	private double sal;
	private double comm;
	public Dept dept;  //一个雇员属于一个部门
	public Emp mgr;  //一个雇员有一个或零个领导
	public Emp(int empno,String ename,String job,double sal,double comm) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
		this.comm = comm;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Dept getDept() {
		return this.dept;
	}

	public void setMgr(Emp mgr) {
		this.mgr = mgr;
	}

	public Emp getMgr() {
		return this.mgr;
	}
	
	public String getInfo() {
		return "雇员编号:" + this.empno + ",雇员姓名:" + this.ename + ",雇员职位:" + this.job + ",雇员工资:" + this.sal + ",雇员薪金:" + this.comm;
	}
}

public class TestDemo03
{
	public static void main(String[] args) {
		Dept dept = new Dept(10,"技术部","beijing");
		Emp ea = new Emp(11,"张三","经理",5000.0,800.0);
		Emp eb = new Emp(22,"李四","负责人",4000.0,500.0);
		Emp ec = new Emp(33,"王五","底层开发",3000.0,200.0);
		dept.setEmps(new Emp[] {ea,eb,ec});  //一个部门有多个雇员
		ea.setDept(dept);  //一个雇员属于一个部门
		eb.setDept(dept);
		ec.setDept(dept);
		ec.setMgr(eb);  //一个雇员有一个领导
		eb.setMgr(ea);
		System.out.println(dept.getInfo());  //部门的信息输出
		for(int i=0;i<dept.getEmps().length;i++) {
			System.out.println(dept.getEmps()[i].getInfo());  //输出该部门下的所有雇员
			if(dept.getEmps()[i].getMgr() != null) {
				System.out.println("\t|-" + dept.getEmps()[i].getMgr().getInfo());
				//如果该雇员有领导，就输出他所对应的领导
			}
		}
		System.out.println(ea.getInfo());  //输出雇员ea的信息
		if(eb.getMgr() != null) {
			System.out.println("\t|-" + eb.getMgr().getInfo());  //输出eb的领导信息
		}
		if(eb.getDept() != null) {
			System.out.println("\t|-" + eb.getDept().getInfo());  //输出eb所在的部门
		}
	} 
}

class Province  //省份类
{
	private int pid;
	private String name;
    public City[] citys;	//一个省份下有多个城市 
	public Province(int pid,String name) {
		this.pid = pid;
		this.name = name;
	}

	public void setCitys(City[] citys) {
		this.citys = citys;
	}

	public City[] getCitys() {
		return this.citys;
	}
	
	public String getInfo() {
		return "省份编号:" + this.pid + ",名称:" + this.name;
	}
}

class City  //城市类
{
	private int cid;
	private String name;
	public Province province;  //一个城市属于一个省份
	public City(int cid,String name) {
		this.cid = cid;
		this.name = name;
	}
	
	public void setProvince(Province province) {
		this.province = province;
	}

	public Province getProvince() {
		return this.province;
	}

	public String getInfo() {
		return "城市编号:" +this.cid + ",城市名称:" + this.name;
	}
}

public class TestDemo04
{
	public static void main(String[] args) {
		Province pro = new Province(1,"河北省");
		City ca = new City(111,"石家庄");
		City cb = new City(222,"秦皇岛");
		City cc = new City(333,"沧州");
		pro.setCitys(new City[] {ca,cb,cc});  //一个省下面有多个城市
		ca.setProvince(pro);  //一个城市属于一个省
		cb.setProvince(pro);
		cc.setProvince(pro);
		System.out.println(pro.getInfo());   //输出省份
		for(int i=0;i<pro.getCitys().length;i++) {
			System.out.println("\t|-" + pro.getCitys()[i].getInfo()); //输出省份下的所有城市
		}
		System.out.println(cb.getProvince().getInfo());  //输出cd城市所对应的省份
	}
}

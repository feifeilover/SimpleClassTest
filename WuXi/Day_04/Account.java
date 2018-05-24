/**
 * 账户类
 * 
 * @author NIIT
 *
 */
public class Account2 {
	// 账号
	private String no;

	// 密码
	private String psw;

	// 余额
	private double yue;

	public Account2(String no, String psw,double yue) {
		this.no = no;
		this.psw=psw;
		this.yue = yue;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public double getYue() {
		return yue;
	}

	public void setYue(double yue) {
		this.yue = yue;
	}

}

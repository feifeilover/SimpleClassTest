import java.util.Scanner;

public class ATM {

	// 记录当前用户的账户信息
	private Account2 account2;

	/**
	 * 登录验证
	 * 
	 * @param no
	 * @param psw
	 * @return
	 */
	public boolean login(String no, String psw) {
		if (no.equals("001") && psw.equals("123456")) {
			account2 = new Account2(no, psw, 0);
			return true;
		}
		return false;
	}

	/**
	 * 进入欢迎页
	 */
	public void goWelcome() {
		boolean isLogout = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("欢迎进入xxxxxx系统");

		while (true) {
			System.out.println("请选择功能菜单  \r\n1.查询余额 2.存款 3.取款 4.退出");
			int i = scanner.nextInt();

			switch (i) {
			case 1:
				System.out.println("当前余额为:" + account2.getYue());
				break;
			case 2:
				if (account2 != null) {
					System.out.println("请输入存款金额");
					int n = scanner.nextInt();
					cunKuan(n);
				}
				break;
			case 3:
				if (account2 != null) {
					System.out.println("请输入取款金额");
					int n = scanner.nextInt();
					quKuan(n);
				}
				break;
			case 4:
				if (account2 != null) {
					logout();
					isLogout = true;
				}
				break;
			default:
				break;
			}

			if (isLogout) {
				break;
			}
		}
		scanner.close();
	}

	/**
	 * 存款
	 */
	private void cunKuan(double n) {
		System.out.println("正在存入.....");
		account2.setYue(account2.getYue() + n);
		System.out.println("存款完成，当前余额是" + account2.getYue());
	}

	/**
	 * 取款
	 */
	private void quKuan(double n) {
		double yue = account2.getYue();
		if (yue > n) {
			System.out.println("正在取出.....");
			yue = yue - n;
			account2.setYue(yue);
			System.out.println("取款完成，当前余额是" + account2.getYue());
		} else {
			System.out.println("余额不足");
		}

	}

	/**
	 * 退卡
	 * 
	 * @param n
	 */
	private void logout() {
		account2 = null;
		System.out.println("退卡成功");
	}

}

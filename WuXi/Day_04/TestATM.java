import java.util.Scanner;

public class TestATM {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入用户名:");
		String name = scan.nextLine();
		System.out.println("请输入密码：");
		String psw = scan.nextLine();
		ATM atm = new ATM();
		atm.login(name, psw);
		atm.goWelcome();
		scan.close();
		
		
	}
}

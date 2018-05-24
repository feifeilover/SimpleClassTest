
import java.util.Scanner;

public class Person {

	public int chuQuan() {
		System.out.println("玩家选择出拳。1：剪刀 2：石头 3：布");
		Scanner in = new Scanner(System.in);
		int quan = in.nextInt();
		in.close();
		return quan;
	}

}

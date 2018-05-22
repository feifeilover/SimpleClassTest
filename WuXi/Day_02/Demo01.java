
public class Test {
	public static void main(String[] args) {
		int n = 0;
		while (true) {
			if (n % 2 == 1 && n % 3 == 2 && n % 5 == 4 && n % 6 == 5 && n % 7 == 0) {
				System.out.println(n);
				break;
			} else {
				n = n + 7;
			}

		}
	}
}

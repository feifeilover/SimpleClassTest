
public class Test01 {
	public static void main(String[] args) {
		int n = 2;
		int flog = 0;
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			sum = sum * 10 + n;
			flog = sum + flog;

		}
		System.out.println(flog);
	}

}

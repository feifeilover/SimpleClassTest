
public class Test03 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4 };
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					if (!(a[i] == a[j]) && !(a[j] == a[k]) && !(a[i] == a[k])) {
						System.out.println("" + a[i] + a[j] + a[k]);
						sum ++;
					}
				}
			}
		}
		System.out.println(sum);
	}
}

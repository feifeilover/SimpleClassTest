
public class Test06 {
	public static void main(String[] args) {
		printRe(3, 4);
		printRe(3, 7);
		printRe(3, 5);
	}
	
	static void printRe(int x,int y) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("----------");
	}
}

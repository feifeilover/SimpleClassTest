
public class Test02 {
	public static void main(String[] args) {
		float sum = 0;
		float h = 100;
		float flog;
		for (int i = 0; i < 10; i++) {
			/*
			 * h = h/2; sum = sum + h;
			 * 
			 * System.out.println("i=" + (i+1) + "h ="+ h);
			 * System.out.println(sum);
			 */
			flog = h + h / 2;
			h = h / 2;
			sum = sum + flog;
			System.out.println("i=" + (i + 1) + "h =" + h);
			System.out.println(sum);
		}
	}
}

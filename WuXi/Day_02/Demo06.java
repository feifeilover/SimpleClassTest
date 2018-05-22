public class Test05 {
	public static void main(String[] args) {
		int sum = 0;
		int a = 0,b = 0,c = 0;
		for(int num =100; num <=999;num++) {
			a = num/100;
			b = num%100/10;
			c = num%10;
			sum = a*a*a + b*b*b + c*c*c;
			if(num == sum) {
				System.out.println(num);
			}
		}
	}
}

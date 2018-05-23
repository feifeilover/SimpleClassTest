package com.igeek.Demo;

public class Demo01 {
	public static void main(String[] args) {
		int[][] arrs = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					arrs[i][j] = 1;
				} else {

					arrs[i][j] = arrs[i - 1][j - 1] + arrs[i - 1][j];
				}

				System.out.print(arrs[i][j] + " ");
			}
			System.out.println();
		}
	}
}


运行后的结果:
1 
1 1 
1 2 1 
1 3 3 1 
1 4 6 4 1 
1 5 10 10 5 1 

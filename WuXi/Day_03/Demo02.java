package com.igeek.Demo;

public class Demo05 {
	public static void main(String[] args) {
		System.out.println(jc(4));  //运行结果为24
	}
	public static int jc(int n){
		if((n-1)==0){
			return 1;
		}
		return n*jc(n-1);
	}
}

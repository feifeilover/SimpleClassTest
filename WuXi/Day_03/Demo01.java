package com.igeek.Demo;

public class Demo02 {
	public static void main(String[] args) {
		String str = "java爱我";
		System.out.println(cutString(7, str));   //运行结果java爱
	}

	/**
	 * 按字节截取字符串 我爱java 5 java爱我
	 * 
	 * @return
	 */
	public static String cutString(int bytes, String str) {
		String result = "";
		// 将字符串->字符数组
		char[] chars = str.toCharArray();
		// 遍历数组
		int count = 0;
		for (char ch : chars) {
			if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				count = count + 1;
			} else {
				count = count + 2;
			}
			if (count <= bytes) {
				result = result + ch;
			} else {
				break;
			}
		}
		return result;
	}
}

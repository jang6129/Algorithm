package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num10872 {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		try {
			num = Integer.parseInt(bf.readLine());
		} catch (IOException e) {

		}
	
		System.out.println(factorial(num));

	}
	
	static int factorial(int num) {
		if (num == 0) return 1;
//		if (num == 1) return 1;
		return (factorial(num - 1) * num);
	}
}

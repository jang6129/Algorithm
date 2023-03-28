package BaekJoon;

import java.util.Scanner;

public class Num1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int counter = 0;
		for (int i = 1; i <= n; i++) {
			if (isHan(i) == true) {
				counter++;
			}
		}
		
		System.out.println(counter);
	}
	
	static boolean isHan(int n) {
		int hundred, ten, rest;
		boolean han;
		
		if (n == 1000) {
			han = false;
		} else if (n >= 100) {
			hundred = n / 100;
			ten = (n - (hundred * 100)) / 10;
			rest = n % 10;
			if (rest - ten == ten - hundred) {
				han = true;
			} else {
				han = false;
			}		
		} else {
			han = true;
		}
		
		return han;
	}
}

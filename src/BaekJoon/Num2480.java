package BaekJoon;

import java.util.Scanner;

public class Num2480 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] inputs = input.split(" ");
		int a = Integer.parseInt(inputs[0]);
		int b = Integer.parseInt(inputs[1]);
		int c = Integer.parseInt(inputs[2]);

		if (a == b && b == c) {
			System.out.println(10000 + (a * 1000));
		} else if (a == b) {
			System.out.println(1000 + (a * 100));
		} else if (a == c) {
			System.out.println(1000 + (a * 100));
		} else if (b == c) {
			System.out.println(1000 + (b * 100));
		} else {
			if (a > b && a > c) {
				System.out.println(a * 100);
			} else if (b > a && b > c) {
				System.out.println(b * 100);
			} else {
				System.out.println(c * 100);
			}
		}

	}
}

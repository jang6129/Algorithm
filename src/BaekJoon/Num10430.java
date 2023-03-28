package BaekJoon;

import java.util.Scanner;

public class Num10430 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] numbers = input.split(" ");
		int A = Integer.parseInt(numbers[0]);
		int B = Integer.parseInt(numbers[1]);
		int C = Integer.parseInt(numbers[2]);

		System.out.println((A + B) % C);
		System.out.println(((A % C) + (B % C)) % C);
		System.out.println((A * B) % C);
		System.out.println(((A % C) * (B % C)) % C);
	}
}

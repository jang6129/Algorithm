package BaekJoon;

import java.util.Scanner;

public class Num10998 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] numbers = input.split(" ");
		System.out.println(Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]));
	}
}

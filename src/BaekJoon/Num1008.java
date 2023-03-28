package BaekJoon;

import java.util.Scanner;

public class Num1008 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] numbers = input.split(" ");
		System.out.println(Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]));
	}
}

package BaekJoon;

import java.util.Scanner;

public class Num1110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int number = n;
		int counter = 0;

		while (true) {
			n = ((n / 10) + (n % 10)) % 10 + ((n % 10) * 10);
			counter++;
			if (n == number) {
				System.out.println(counter);
				break;
			}
		}
	}

}

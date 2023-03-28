package BaekJoon;

import java.util.Scanner;

public class Num10951 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = -1;
		int b = -1;

		while (sc.hasNextLine()) {
			String[] input = sc.nextLine().split(" ");
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			System.out.println(a + b);
		}

	}
}

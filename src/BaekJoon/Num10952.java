package BaekJoon;

import java.util.Scanner;

public class Num10952 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = -1;
		int b = -1;
		
		while (true) {
			String[] input = sc.nextLine().split(" ");
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			if (a + b == 0) {
				break;
			}
			System.out.println(a + b);
		}


	}
}

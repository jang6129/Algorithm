package BaekJoon;

import java.util.Scanner;

public class Num11022 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(sc.nextLine());
		
		for(int i = 1 ; i <= t; i++) {
			String[] input = sc.nextLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c = a + b;
			sb.append("Case #" + i + ": " + a + " + " + b + " = " + c + "\n");
		}
		System.out.println(sb.toString());
	}
}

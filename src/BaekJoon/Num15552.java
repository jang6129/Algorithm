package BaekJoon;

import java.util.Scanner;

public class Num15552 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < n; i ++) {
			String input = sc.nextLine();
			String[] inputs = input.split(" ");
			int sum = Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1]);
			sb.append(sum + "\n");
		}
		
		System.out.println(sb.toString());
	}
}

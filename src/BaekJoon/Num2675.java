package BaekJoon;

import java.util.Scanner;

public class Num2675 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int s = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < s; i++) {
			String input[] = sc.nextLine().split(" ");
			int n = Integer.parseInt(input[0]);
			String word = input[1];
			
			for (int k = 0; k < word.length(); k++) {
				for (int j = 0; j < n; j++) {
					sb.append(word.charAt(k));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
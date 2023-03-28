package BaekJoon;

import java.util.Scanner;

public class Num10950 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < num; i++) {
			String input = sc.nextLine();
			String[] inputs = input.split(" ");
			System.out.println(Integer.parseInt(inputs[0]) + Integer.parseInt(inputs[1]));
		}
	}
}

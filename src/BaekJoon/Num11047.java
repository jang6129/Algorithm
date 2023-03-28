package BaekJoon;

import java.util.Scanner;

public class Num11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		long[] coins = new long[Integer.parseInt(input[0])];
		long value = Long.parseLong(input[1]);
		int count = 0;
		
		for(int i = 0; i < coins.length; i++) {
			coins[i] = sc.nextLong();
		}
		
		for(int i = coins.length - 1; i >= 0; i--) {
			if (value >= coins[i]) {
				count += value / coins[i];
				value = value % coins[i];
			}
		}
		
		System.out.println(count);
		
	}

}

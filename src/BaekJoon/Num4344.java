package BaekJoon;

import java.util.Scanner;

public class Num4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int c = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < c; i++) {
			String[] input = sc.nextLine().split(" ");
			double n = Double.parseDouble(input[0]);
			double average = 0;
			double aboveAverage = 0;

			for (int k = 1; k <= n; k++) {
				average += Integer.parseInt(input[k]);
			}

			average = average / n;

			for (int j = 1; j <= n; j++) {
				if (Integer.parseInt(input[j]) > average) {
					aboveAverage++;
				}
			}

			System.out.printf("%.3f", aboveAverage / n * 100);
			System.out.println("%");

		}

	}
}

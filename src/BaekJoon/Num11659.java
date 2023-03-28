package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num11659 {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;

		try {
			String[] input = bf.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);

			String[] inputs = bf.readLine().split(" ");
			int[] numbers = new int[N];
			int[] sums = new int[N];

			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(inputs[i]);
				if (i == 0)
					sums[i] = numbers[i];
				else
					sums[i] = sums[i - 1] + numbers[i];
			}

			for (int a = 0; a < M; a++) {
				input = bf.readLine().split(" ");
				int i = Integer.parseInt(input[0]);
				int j = Integer.parseInt(input[1]);
				System.out.println(sums[j-1] - sums[i - 1]);
			}

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

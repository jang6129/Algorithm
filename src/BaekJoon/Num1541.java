package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int sum = 0;

		if (input.contains("-")) {
			String[] blocks = input.split("-");

			sum += calc(blocks[0]);

			for (int i = 1; i < blocks.length; i++) {
				sum -= calc(blocks[i]);
			}

			System.out.println(sum);
		} else {
			System.out.println(calc(input));
		}
	}

	private static int calc(String block) {
		String[] nums = block.split("\\+");
		int sum = 0;

		for (String num : nums) {
			sum += Integer.parseInt(num);
		}

		return sum;
	}
}

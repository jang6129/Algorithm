package BaekJoon;

import java.util.Arrays;

public class Num4673 {
	public static void main(String[] args) {
		boolean isSelf[] = new boolean[10001];
		Arrays.fill(isSelf, true);
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= 10000; i++) {
			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 9) {
				int k = i;
				while (genesis(k) <= 10000) {
					k = genesis(k);
					isSelf[k] = false;
				}
			}
		}
		
		for (int i = 1; i <= 10000; i++) {
			if (isSelf[i] == true) {
				int k = i;
				while (genesis(k) <= 10000) {
					k = genesis(k);
					isSelf[k] = false;
				}
			}
		}

		for (int i = 1; i <= 10000; i++) {
			if (isSelf[i] == true) {
				sb.append(i + "\n");
			}
		}
		
		System.out.println(sb.toString());
	}

	static int genesis(int n) {
		int answer;
		int thousand = n / 1000;
		int hundred = (n - (thousand * 1000)) / 100;
		int ten = (n - (thousand * 1000) - (hundred * 100)) / 10;
		int rest = n % 10;

		if (n == 10000) {
			answer = 10001;
		} else if (n >= 1000) {
			answer = n + thousand + hundred + ten + rest;
		} else if (n >= 100) {
			answer = n + hundred + ten + rest;
		} else if (n >= 10) {
			answer = n + ten + rest;
		} else {
			answer = n + n;
		}
		return answer;
	}

}

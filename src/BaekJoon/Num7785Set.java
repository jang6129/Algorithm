package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Num7785Set {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n;
		HashSet<String> set = new HashSet<>();

		try {
			n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String[] input = br.readLine().split(" ");
				if (input[1].equals("enter")) {
					set.add(input[0]);
				} else if (input[1].equals("leave")) {
					set.remove(input[0]);
				}
			}

		} catch (IOException e) {
		}

		Set<String> tree = new TreeSet<>(set);
		Object[] sortedSet = tree.toArray();

		for (int i = sortedSet.length - 1; i >= 0; i--) {
			sb.append(sortedSet[i] + "\n");
		}

		System.out.println(sb.toString());
	}
}

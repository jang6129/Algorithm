package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Num10815 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N, M;
		HashSet<Integer> set = new HashSet<>();

		try {
			N = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			
			for (String s : input) {
				set.add(Integer.parseInt(s));
			}
			
			M = Integer.parseInt(br.readLine());
			String[] input2 = br.readLine().split(" ");
			
			for (String s : input2) {
				if (set.contains(Integer.parseInt(s))) {
					sb.append(1 + " ");
				} else {
					sb.append(0 + " ");
				}
			}
			System.out.println(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

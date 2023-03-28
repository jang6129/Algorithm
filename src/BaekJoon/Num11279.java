package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Num11279 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		try {
			int N = Integer.parseInt(br.readLine());
		
			for(int i = 0; i < N; i++) {
				String input = br.readLine();
				if (input.equals("0")) {
					if (!q.isEmpty()) {
						sb.append(q.poll() + System.getProperty("line.separator"));
					} else {
						sb.append(0 + System.getProperty("line.separator"));
					}
				} else {
					q.add(Integer.parseInt(input));
				}
			}
		} catch (IOException e) {
			
		}
		System.out.println(sb.toString());
	}
}

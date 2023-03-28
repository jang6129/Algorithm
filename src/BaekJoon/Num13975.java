package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Num13975 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int K = Integer.parseInt(br.readLine());
		
		for(int a = 0; a < K; a++) {
			int n = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			ArrayList<Integer> list = new ArrayList<>();
			for(int b = 0; b < n; b++) {
				list.add(Integer.parseInt(input[b]));
			}
			page(list, sb);
		}
		System.out.println(sb);
	}
	
	static void page(ArrayList<Integer> list, StringBuilder sb) {
		int size = 0;
		
		while (list.size() > 1) {
			Collections.sort(list);
			list.set(0, list.get(0) + list.get(1));
			size += list.get(0);
			list.remove(1);
		}
		sb.append(String.valueOf(size) + "\n");
	}
}

package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1969 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(tk.nextToken());
		int M = Integer.parseInt(tk.nextToken());
		
		int[][] dna = new int[M][4];
		int hd = 0;
		
		for (int a = 0; a < N; a++) {
			String input = br.readLine();
			for (int b = 0; b < M; b++) {
				char target = input.charAt(b);
				
				if (target == 'A') {
					dna[b][0]++;
				}
				else if (target == 'C') {
					dna[b][1]++;
				}
				else if (target == 'G') {
					dna[b][2]++;
				}
				else
					dna[b][3]++;
			}
		}
		
		for (int a = 0; a < M; a++) {
			int max = dna[a][0];
			for (int b = 0; b < 3; b++) {
				if (dna[a][b] < dna[a][b+1]) {
					max = dna[a][b+1];
				}
			}
		}
		
	}
}

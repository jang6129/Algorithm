package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public abstract class Num19532BF {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x,y;
		int[] arr = new int[6];
		StringTokenizer tk = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 6; i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		
		for (x = -999; x <= 999; x++) {
			for (y = -999; y <= 999; y++) {
				if (arr[0]*x+arr[1]*y == arr[2] && arr[3]*x+arr[4]*y == arr[5]) {
					System.out.println(x + " " + y);
				}
			}
		}
		

	}
}

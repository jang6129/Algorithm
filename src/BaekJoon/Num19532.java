package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num19532 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double x,y;
		double[] arr = new double[6];
		StringTokenizer tk = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 6; i++) {
			arr[i] = Double.parseDouble(tk.nextToken());
		}
		
		x = (((arr[2] / arr[1]) - (arr[5] / arr[4])) / ((arr[0] / arr[1]) - (arr[3] / arr[4])));
		y = (arr[2] / arr[1]) - (arr[0] / arr[1] * x);
		
		System.out.print((int)x + " " + (int)y);
	}
}

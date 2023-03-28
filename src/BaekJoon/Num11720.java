package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num11720 {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		
		try {
			int n = Integer.parseInt(bf.readLine());
			int[] arr = new int[n];
			String numbers = bf.readLine();
			
			for(int i = 0; i < n; i++) {
				arr[i] = (int)numbers.charAt(i) - 48;
				sum += arr[i];
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(sum);
	}
}

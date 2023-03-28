package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Num2750 {
	public static void main(String[] args) {
		int N;
		ArrayList<Integer> arr = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine());
			for(int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(br.readLine()));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Collections.sort(arr);
		
		for(int i : arr) {
			System.out.println(i);
		}
	}
}

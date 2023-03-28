package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Num11399 {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N;
		ArrayList<Integer> P = new ArrayList<>();
		
		try {
			N = Integer.parseInt(bf.readLine());
			String input[] = bf.readLine().split(" ");
			for (int i = 0; i < input.length; i++) {
				P.add(Integer.parseInt(input[i]));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Collections.sort(P);
		
		int counter = 0;
		int answer = 0;
		int arr[] = new int[P.size()];
		
		for (int i  = 0; i < P.size(); i++) {
			counter += P.get(i);
			arr[i] = counter;
		}
		
		for(int i : arr) {
			answer += i;
		}
		
		System.out.println(answer);
	}
}

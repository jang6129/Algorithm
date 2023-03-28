package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Num1076 {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long sum = 0;
		
		map.put("black", 0);
		map.put("brown", 1);
		map.put("red", 2);
		map.put("orange", 3);
		map.put("yellow", 4);
		map.put("green", 5);
		map.put("blue", 6);
		map.put("violet", 7);
		map.put("grey", 8);
		map.put("white", 9);
		
		try {
			String firstLine = br.readLine();
			String secondLine = br.readLine();
			String thirdLine = br.readLine();
			long square = 1;
			for (int i = map.get(thirdLine); i >= 1; i--) {
				square *= 10;
			}
			sum = ((map.get(firstLine) * 10) + map.get(secondLine)) * square;
			
		} catch (IOException e) {
			
		}
		
		System.out.println(sum);
		
	}
}

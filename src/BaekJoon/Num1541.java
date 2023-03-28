package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Num1541 {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Queue<Character> queue = new LinkedList<>();
		ArrayList<Integer> arr = new ArrayList<>();
		String input = null;
		int stack = 0;
		
		try {
			input = bf.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String inputs[] = input.split("'+'");
		// 55-50+40
		// 55-50
		// 40
		for(String s : inputs) {
			if (!s.contains("'-'")) {
				stack += Integer.parseInt(s);
			} else {
				String inputss[] = s.split("-");
				for(String ss : inputss) {
					if (ss != null) {
					stack -= Integer.parseInt(ss);
					}
				}
			}
		}
		
		System.out.println(stack);
	}
}
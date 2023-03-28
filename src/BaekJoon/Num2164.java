package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Num2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> deque = new ArrayDeque<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = N; i > 0; i--) {
			deque.add(i);
		}
		
		while (deque.size() > 1) {
		deque.pollLast();
		deque.addFirst(deque.pollLast());
		}
		
		System.out.println(deque.peek());
	}
}

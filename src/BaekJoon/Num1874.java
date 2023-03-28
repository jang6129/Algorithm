package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Num1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int stackCounter = 1;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());

			if (!stack.contains(arr[i])) {
				while (!stack.contains(arr[i])) {
					stack.add(stackCounter++);
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			} else {
				if (stack.contains(arr[i]) && stack.peek() > arr[i]) {
					System.out.print("No");
					return;
				}
				while (stack.contains(arr[i])) {
					stack.pop();
					sb.append("-\n");
				}
			}	
		}
		
		System.out.println(sb.toString());
	}
}

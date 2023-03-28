package BaekJoon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Num10845 {
	public static void main(String[] args) {
		
		Deque<Integer> queue = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		Scanner scan = new Scanner(System.in);
		int programLength = Integer.parseInt(scan.nextLine());

		for (int i = 0; i < programLength; i++) {
			
			String command[] = scan.nextLine().split(" ");
			
			if (command[0].equals("push")) {
				queue.add(Integer.parseInt(command[1]));
			}
			
			else if (command[0].equals("pop")) {
				if (queue.size() == 0) {
					sb.append(-1 + "\n");
				} else {
					sb.append(queue.pollFirst() + "\n");
				}
			}
			
			else if (command[0].equals("size")) {
				sb.append(queue.size() + "\n");
			}
			
			else if (command[0].equals("empty")) {
				if (queue.size() == 0) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			}
			
			else if (command[0].equals("front")) {
				if (queue.size() == 0) {
					sb.append(-1 + "\n");
				} else {
					sb.append(queue.getFirst() + "\n");
				}
			}
			
			else if (command[0].equals("back")) {
				if (queue.size() == 0) {
					sb.append(-1 + "\n");
				} else {
					sb.append(queue.getLast() + "\n");
				}
			}
			
		}
		
		System.out.println(sb.toString());
		
	}
}

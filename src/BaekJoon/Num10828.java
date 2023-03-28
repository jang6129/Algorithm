package BaekJoon;

import java.util.Scanner;
import java.util.Stack;

public class Num10828 {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int programLength = Integer.parseInt(scan.nextLine());

		for (int i = 0; i < programLength; i++) {
			String command[] = scan.nextLine().split(" ");
			if (command[0].equals("push")) {
				stack.push(Integer.parseInt(command[1]));
			} else if (command[0].equals("pop")) {
				if (stack.size() == 0) {
					sb.append(-1 + "\n");
				} else {
					sb.append(stack.pop() + "\n");
				}
			} else if (command[0].equals("size")) {
				if (stack.size() == 0) {
					sb.append(0 + "\n");
				} else {
					sb.append(stack.size() + "\n");
				}
			} else if (command[0].equals("empty")) {
				if (stack.size() == 0) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			} else if (command[0].equals("top")) {
				if (stack.size() == 0) {
					sb.append(-1 + "\n");
				} else if (stack.size() > 0) {
					sb.append(stack.peek() + "\n");
				} else {
					sb.append("Wrong Command\n");
				}
			}
		}
		System.out.println(sb.toString());
	}
}

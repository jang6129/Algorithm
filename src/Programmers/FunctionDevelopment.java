package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FunctionDevelopment {
	public static ArrayList<Integer> solution(int[] progresses, int[] speeds) {
		Queue<Integer> progressQ = new LinkedList<>();
		Queue<Integer> speedQ = new LinkedList<>();
		int time = 1;
		int stack = 0;
		ArrayList<Integer> answer = new ArrayList<>();
		ArrayList<Integer> counter = new ArrayList<>();

		for (int i = 0; i < progresses.length; i++) {
			progressQ.add(progresses[i]);
			speedQ.add(speeds[i]);
		}

		while (!progressQ.isEmpty()) {
			if (progressQ.peek() + (speedQ.peek() * time) >= 100 && progressQ.size() == 1) {
				progressQ.poll();
				speedQ.poll();
				stack++;
				counter.add(stack);
			} else if (progressQ.peek() + (speedQ.peek() * time) >= 100) {
				progressQ.poll();
				speedQ.poll();
				stack++;
			} else {
				counter.add(stack);
				time++;
				stack = 0;
			}
		}
		
		for (int i = 0; i < counter.size(); i++) {
			if (counter.get(i) != 0) {
				answer.add(counter.get(i));
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int progresses[] = { 95, 90, 99, 99, 80, 99 };
		int speeds[] = { 1, 1, 1, 1, 1, 1 };

		ArrayList<Integer> answer = solution(progresses, speeds);

		for (int i : answer) {
			System.out.println(i);
		}
	}
}

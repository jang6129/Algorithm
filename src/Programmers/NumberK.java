package Programmers;

import java.util.ArrayList;
import java.util.Collections;

public class NumberK {
	public static void main(String[] args) {
		int array[] = { 1, 5, 2, 6, 3, 7, 4 };
		int commands[][] = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		
		int answer[] = solution(array, commands);

		for(int i : answer) {
			System.out.println(i);
		}
	}

	public static int[] solution(int[] array, int[][] commands) {
		int answer[] = new int[commands.length];
		
		for (int i = 0; i < commands.length; i++) {
			ArrayList<Integer> counter = new ArrayList<>();
			for (int k = commands[i][0] - 1; k < commands[i][1]; k++) {
				counter.add(array[k]);
			}
			Collections.sort(counter);
			answer[i] = counter.get(commands[i][2] - 1);
		}

		return answer;
	}
}
package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {

	public static void main(String[] args) {
		int[] numbers = { 6, 10, 2 };
		
		System.out.println(solution(numbers));

	}

	public static String solution(int[] numbers) {
		String arr[] = new String[numbers.length];
		ArrayList<String> arrs = new ArrayList<>();

		for (int i = 0; i < numbers.length; i++) {
			arr[i] = String.valueOf(numbers[i]);
		}

		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o2 + o1).compareTo(o1 + o2);
			}
		});
		
		if (arr[0].equals("0")) {
			return "0";
		}
		
		String answer = "";
		
		for(String s : arr) {
			answer += s;
		}
		
		return answer;
	}

}

package BaekJoon;

import java.util.Scanner;

public class Num1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine().toUpperCase();
		
		int counter[] = new int[26];
		char answer = '0';
		int max = 0;
		
		for(int i = 0; i < word.length(); i++) {
			if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
				counter[word.charAt(i) - (int)'A']++;
			}
		}
		
		for(int i = 0; i < counter.length; i++) {
			if (counter[i] > max) {
				max = counter[i];
				answer = (char) (i + 65);
			} else if (counter[i] == max) {
				answer = '?';
			}
		}
		
		System.out.println(answer);
	}
}

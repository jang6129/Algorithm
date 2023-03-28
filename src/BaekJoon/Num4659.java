package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num4659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = "input";
		String vowel = "aeiou";
 		
		while (input != "end") {
			input = br.readLine();
			
			if(input == "end")
				break;
			
			if (input.length() >= 3) {
				for (int i = 2; i < input.length(); i++) {
					if (vowel.contains(String.valueOf(input.charAt(i-2))) && vowel.contains(String.valueOf(input.charAt(i-1))) 
							&& vowel.contains(String.valueOf(input.charAt(i)))) {
						sb.append("<" + input + "> is not acceptable.\n");
						continue;
					}
					else if (!vowel.contains(String.valueOf(input.charAt(i-2))) && !vowel.contains(String.valueOf(input.charAt(i-1))) 
							&& !vowel.contains(String.valueOf(input.charAt(i)))) {
						sb.append("<" + input + "> is not acceptable.\n");
						continue;
					}
				}
			}
			
			if (!input.contains("a") && !input.contains("e") && !input.contains("i") && !input.contains("o")
					&& !input.contains("u")) {
				sb.append("<" + input + "> is not acceptable.\n");
				continue;
			}
			
			if (input.length() >= 2) {
				for (int i = 1; i < input.length(); i++) {
					if (input.charAt(i-1) == input.charAt(i) && (input.charAt(i) != 'e' || input.charAt(i) != 'o')) {
						sb.append("<" + input + "> is not acceptable.\n");
						continue;
					}
				}
			}
			else
				sb.append("<" + input + "> is acceptable.\n");
		}
		
		System.out.println(sb.toString());
	}
}

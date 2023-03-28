package DoItTutorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class p121_ex3_6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] x = {
				"abstract", "assert", "boolean", "break", "case", "catch",
				"float", "for", "super", "swtich", "void", "while"
		};
		
		System.out.println("원하는 키워드를 입력하세요 : ");
		String key = sc.next();
		
		int idx = Arrays.binarySearch(x, key);
		
		if (idx < 0) {
			System.out.println("해당하는 키워드가 없습니다.\n");
		}
		else
			System.out.println("해당 키워드는 x[" + idx + "]에 있습니다.\n");
	}
}

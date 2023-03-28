package DoItTutorial;

import java.util.Scanner;

public class p114_q3 {
	static int searchIdx(int[] a, int n, int key, int[] idx) {
		int counter = 0;
		
		for(int i = 0; i < n; i++) {
			if (a[i] == key) {
				idx[counter] = 0;
				counter++;
			}
		}
		
		return counter;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("요솟수 : ");
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] idx = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = sc.nextInt();
		}

		System.out.println("찾을 값을 입력하세요 : ");
		int key = sc.nextInt();
		
		System.out.println(searchIdx(a, n, key, idx));
	}
}

package DoItTutorial;

import java.util.Scanner;

public class p115_q5 {
	static int binSearchX(int[] a, int n, int key) {
		int front = 0;
		int rear = n - 1;
		int center, answer;

		while (front <= rear) {
			center = front + rear / 2;
			if (a[center] == key) {
				answer = center;
				for (int i = center; i > 0; i--) {
					if (a[i - 1] == key)
						answer = i - 1;
				}
				return answer;
			} else if (a[center] > key) {
				rear = center - 1;
			} else {
				front = center + 1;
			}
		}
		return -1;
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

		System.out.println(binSearchX(a, n, key));
	}
}

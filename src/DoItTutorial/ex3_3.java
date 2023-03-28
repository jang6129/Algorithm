package DoItTutorial;

import java.util.Scanner;

public class ex3_3 {
	static int seqSearch(int[] a, int n, int key) {
		int i = 0;
		a[n] = key;
		
		while(true) {
			if(a[i] == key) {
				break;
			}
			i++;
		}
		return i == n? -1 : i;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("요솟수 : ");
		int num = sc.nextInt();
		int[] x = new int[num+1];
		
		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		
		System.out.println("찾을 값을 입력하세요 : ");
		int key = sc.nextInt();
		
		int result = seqSearch(x, num, key);
		
		if (result == -1)
			System.out.println("값이 존재하지 않습니다.");
		else
			System.out.println("값은 " + result + "번 인덱스에 있습니다.\n");
	}
}

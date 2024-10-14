package BaekJoon;

import java.util.Scanner;

public class 바구니_뒤집기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] basket = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            basket[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            while (start < end) {
                int temp = basket[start];
                basket[start] = basket[end];
                basket[end] = temp;
                start++;
                end--;
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(basket[i] + " ");
        }

    }
}

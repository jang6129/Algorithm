package BaekJoon.약수_배수와_소수_2;

import java.util.Scanner;

public class 가로수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] gap = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            gap[i] = arr[i + 1] - arr[i];
        }

        int num = gap[0];
        for (int i = 1; i < n - 1; i++) {
            num = gcd(num, gap[i]);
        }

        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            count += gap[i] / num - 1;
        }

        System.out.println(count);
    }

    public static int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

}

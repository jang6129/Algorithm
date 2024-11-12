package BaekJoon.약수_배수와_소수_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 베르트랑_공준 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            list.add(n);
            max = Math.max(max, n);
        }

        boolean[] prime = new boolean[2 * max + 1];
        Arrays.fill(prime, true);
        for (int i = 2; i * i <= 2 * max; i++) {
            if (isPrime(i)) {
                for (int j = i * i; j <= 2 * max; j += i) {
                    prime[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : list) {
            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (prime[i]) count++;
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

}

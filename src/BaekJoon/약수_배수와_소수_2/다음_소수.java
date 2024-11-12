package BaekJoon.약수_배수와_소수_2;

import java.util.Scanner;

public class 다음_소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nextPrime(sc.nextLong()) + "\n");
        }

        System.out.println(sb);
    }

    public static boolean isPrime(long num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (long i = 5; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static long nextPrime(long num) {
        while (true) {
            if (isPrime(num)) return num;
            num++;
        }
    }

}

package BaekJoon.약수_배수와_소수_2;

import java.util.ArrayList;
import java.util.Scanner;

public class 골드바흐_파티션 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }

        ArrayList<Integer> prime = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (isPrime(i)) {
                prime.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            int count = 0;
            for (int i = 0; i < prime.size(); i++) {
                for (int j = i; j < prime.size(); j++) {
                    if (prime.get(i) + prime.get(j) == num) {
                        count++;
                    }
                }
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

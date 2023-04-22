package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Num2023_2 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for (int i = (int) Math.pow(10, N - 1) + 1; i < (int) Math.pow(10, N); i++) {
            if (i % 2 != 0 && isPrime(i)) {
                if (isExtraordinary(i)) sb.append(i + "\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isExtraordinary(int num) {
        for (int i = 1; i < N; i++) {
            if (!isPrime(num / (int) Math.pow(10, i))) return false;
        }

        return true;
    }

}

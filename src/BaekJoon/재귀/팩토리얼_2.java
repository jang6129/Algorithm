package BaekJoon.재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 팩토리얼_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(factorial(n));
    }

    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}

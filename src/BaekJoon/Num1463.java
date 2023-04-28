package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1463 {

    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        memo = new int[N+1];
        for (int i = 0; i <= N; i++) {
            memo[i] = -1;
        }
        memo[1] = 0;
        memo[2] = 1;
        memo[3] = 1;

        System.out.println(fun(N));
    }

    static int fun(int n) {
      if (n == 1) return 0;
      if (memo[n] != -1) return memo[n];

      int count = fun(n - 1) + 1;

      if (n % 3 == 0) count = Math.min(count, fun(n / 3) + 1);
      if (n % 2 == 0) count = Math.min(count, fun(n / 2) + 1);

      memo[n] = count;

      return count;
    }

}

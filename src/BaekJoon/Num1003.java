package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] dp = new int[41][2];

        dp[0][0] = 1; // f(0) is called once for f(0)
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1; // f(1) is called once for f(1)

        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0]; // f(0) calls for f(i)
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1]; // f(1) calls for f(i)
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
}
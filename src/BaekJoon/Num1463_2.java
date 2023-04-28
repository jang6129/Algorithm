package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1463_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        int[] memo = new int[N+1];
        for (int i = 0; i <= N; i++) {
            memo[i] = -1;
        }
        memo[1] = 0;
        for (int i = 2; i <= N; i++) {
            if (memo[i] != -1) continue;
            answer = memo[i - 1] + 1;

            if (i % 3 == 0) answer = Math.min(answer, memo[i / 3] + 1);
            if (i % 2 == 0) answer = Math.min(answer, memo[i / 2] + 1);

            memo[i] = answer;
        }

        System.out.println(answer);
    }
}

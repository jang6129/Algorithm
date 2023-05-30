package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Num2775 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] floors = new int[T];
        int[] rooms = new int[T];
        int topFloor = 0;

        for (int i = 0; i < T; i++) {
            floors[i] = Integer.parseInt(br.readLine());
            rooms[i] = Integer.parseInt(br.readLine());

            topFloor = Math.max(topFloor, floors[i]);
        }

        int[][] dp = new int[topFloor + 1][15];

        for (int i = 1; i <= 14; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < topFloor + 1; i++) {
            for (int j = 1; j <= 14; j++) {
                for(int k = 1; k <= j; k++) {
                    dp[i][j] += dp[i-1][k];
                }
            }
        }

        for (int i = 0; i < T; i++) {
            sb.append(dp[floors[i]][rooms[i]] + "\n");
        }

        System.out.println(sb);
    }

}

package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num1976 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] map = new int[N + 1][N + 1];
        // N번까지 map 그려주기
        for (int i = 1; i <= N; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int n = Integer.parseInt(tk.nextToken());
                map[i][j] = n;
                map[j][i] = n;
            }
        }
        // 방문 도시 list 받아주기
        int[] list = new int[M];
        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            list[i] = Integer.parseInt(tk.nextToken());
        }



    }
}

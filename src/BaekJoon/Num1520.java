package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1520 {

    static int M, N;
    static int[][] map;
    static int[][] dp;
    static int[] X = {0, 1, 0, -1};
    static int[] Y = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        M = Integer.parseInt(tk.nextToken());
        N = Integer.parseInt(tk.nextToken());

        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(DFS(0, 0));
    }

    static int DFS(int x, int y) {
        if (x == M - 1 && y == N - 1) return 1;
        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int xx = x + X[i];
            int yy = y + Y[i];
            if (xx < 0 || yy < 0 || xx >= M || yy >= N) continue;
            if (map[x][y] <= map[xx][yy]) continue;
            dp[x][y] += DFS(xx, yy);
        }

        return dp[x][y];
    }

}

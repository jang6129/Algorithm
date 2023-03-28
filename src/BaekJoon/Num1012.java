package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num1012 {

    static int M, N, K;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int a = 0; a < T; a++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            M = Integer.parseInt(tk.nextToken());
            N = Integer.parseInt(tk.nextToken());
            K = Integer.parseInt(tk.nextToken());
            int[][] arr = new int[M][N];
            for (int b = 0; b < K; b++) {
                tk = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(tk.nextToken());
                int column = Integer.parseInt(tk.nextToken());
                arr[row][column] = 1;
            }
            sb.append(worm(arr) + "\n");
        }

        System.out.println(sb);
    }

    static int worm(int arr[][]) {
        Queue<int[]> queue = new LinkedList<>();
        int[] X = {1, 0, -1, 0};
        int[] Y = {0, -1, 0, 1};
        int[][] visited = new int[M][N];
        int worms = 0;

        for (int a = 0; a < M; a++) {
            for (int b = 0; b < N; b++) {
                if (arr[a][b] == 1 && visited[a][b] != 1) {
                    queue.add(new int[] {a, b});
                    worms++;
                    while (!queue.isEmpty()) {
                        int[] coordinate = queue.poll();
                        int x = coordinate[0];
                        int y = coordinate[1];
                        visited[x][y] = 1;
                        for (int c = 0; c < 4; c++) {
                            int xc = x + X[c];
                            int yc = y + Y[c];
                            if (xc >= 0 && yc >= 0 &&
                                    xc < M && yc < N &&
                                    arr[xc][yc] == 1 &&
                                    visited[xc][yc] != 1) {
                                queue.add(new int[] {xc, yc});
                            }
                        }
                    }
                }
            }
        }

        return worms;
    }
}


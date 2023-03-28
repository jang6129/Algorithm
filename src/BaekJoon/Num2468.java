package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num2468 {

    static int[][] arr;
    static int[] X = {1, 0, -1, 0};
    static int[] Y = {0, -1, 0, 1};
    static int N;
    static int max = 0;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int a = 0; a < N; a++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            for (int b = 0; b < N; b++) {
                arr[a][b] = Integer.parseInt(tk.nextToken());
                if (arr[a][b] > max) max = arr[a][b];
            }
        }

        // 최대 높이 - 1 만큼 반복
        for (int i = 1; i < max; i++) {
            BFS(i);
        }

        System.out.println(answer);
    }

    static void BFS(int level) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[N][N];
        int[][] safe = new int[N][N];
        int counter = 0;

        for (int a = 0; a < N; a++) {
            for (int b = 0; b < N; b++) {
                if (arr[a][b] > level) safe[a][b] = 1;
            }
        }

        for (int a = 0; a < N; a++) {
            for (int b = 0; b < N; b++) {
                if (safe[a][b] == 1 && visited[a][b] != 1) {
                    queue.add(new int[] {a, b});
                    visited[a][b] = 1;
                    counter++;
                    while(!queue.isEmpty()) {
                        int[] coordinate = queue.poll();
                        int x = coordinate[0];
                        int y = coordinate[1];
                        for (int c = 0; c < 4; c++) {
                            int xc = x + X[c];
                            int yc = y + Y[c];
                            if (xc >= 0 && xc < N && yc >=0 && yc < N) {
                                if (safe[xc][yc] == 1 && visited[xc][yc] != 1) {
                                    queue.add(new int[] {xc, yc});
                                    visited[xc][yc] = 1;
                                }
                            }
                        }
                    }
                }
                if (counter > answer) answer = counter;
            }
        }

    }

}

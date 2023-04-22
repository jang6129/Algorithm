package BaekJoon;

import java.util.*;
import java.io.*;

public class Num2573 {
    static int N, M;
    static int[][] iceberg;
    static int[][] temp;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        iceberg = new int[N][M];
        temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                iceberg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;

        while (true) {
            visited = new boolean[N][M];
            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && iceberg[i][j] > 0) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            if (count >= 2) {
                System.out.println(time);
                break;
            } else if (count == 0) {
                System.out.println(0);
                break;
            }

            time++;
            meltIcebergAndResetVisited();
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && iceberg[nx][ny] > 0) {
                dfs(nx, ny);
            }
        }
    }

    static void meltIcebergAndResetVisited() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (iceberg[i][j] > 0) {
                    int seaCount = 0;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && iceberg[nx][ny] == 0) {
                            seaCount++;
                        }
                    }

                    temp[i][j] = Math.max(iceberg[i][j] - seaCount, 0);
                } else {
                    temp[i][j] = 0;
                }
            }
        }

        // Update the iceberg after melting and reset visited array
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                iceberg[i][j] = temp[i][j];
                visited[i][j] = false;
            }
        }
    }
}
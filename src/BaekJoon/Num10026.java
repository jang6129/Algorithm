package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Num10026 {

    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] X = {1, 0, -1, 0};
    static int[] Y = {0, 1, 0, -1};
    static int count = 0;
    static int countC = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    DFS(i, j);
                    count++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    DFSc(i, j);
                    countC++;
                }
            }
        }

        System.out.println(new StringBuffer().append(count).append(' ').append(countC));
    }

    static void DFS(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int xx = x + X[i];
            int yy = y + Y[i];
            if (xx < 0 || yy < 0 || xx >= N || yy >= N) continue;
            if (visited[xx][yy]) continue;
            if (map[x][y] != map[xx][yy]) continue;
            DFS(xx, yy);
        }
    }

    static void DFSc(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int xx = x + X[i];
            int yy = y + Y[i];
            if (xx < 0 || yy < 0 || xx >= N || yy >= N) continue;
            if (visited[xx][yy]) continue;
            if ((map[x][y] == 'R' || map[x][y] == 'G') && (map[xx][yy] == 'R' || map[xx][yy] == 'G')) {
                DFSc(xx,yy);
            } else if (map[x][y] == 'B' && map[xx][yy] == 'B') {
                DFSc(xx, yy);
            }
        }

    }


}

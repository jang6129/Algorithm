package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1987 {

    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static boolean[] abc = new boolean[26];
    static int[] X = {1, 0, -1, 0};
    static int[] Y = {0, 1, 0, -1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        R = Integer.parseInt(tk.nextToken());
        C = Integer.parseInt(tk.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            StringBuilder input = new StringBuilder(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        DFS(0, 0, 0);

        System.out.println(max);
    }

    static void DFS(int x, int y, int count) {
        visited[x][y] = true;
        int curABC = (int) map[x][y] - 65;
        abc[curABC] = true;
        count++;
        max = Math.max(max, count);
        for (int i = 0; i < 4; i++) {
            int xx = x + X[i];
            int yy = y + Y[i];
            if (xx < 0 || yy < 0 || xx >= R || yy >= C) continue;
            if (visited[xx][yy]) continue;
            if (abc[(int) map[xx][yy] - 65]) continue;
            DFS(xx, yy, count);
        }
        // 같은 경로를 여러번 탐색해야 하는 경우 지나온 길을 모두 원상복구 해준다.
        visited[x][y] = false;
        abc[curABC] = false;
    }

}

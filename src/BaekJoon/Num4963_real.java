package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num4963_real {

    static int[] X = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] Y = {1, 1, 0, -1, -1, -1, 0, 1};
    static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            w = Integer.parseInt(tk.nextToken());
            h = Integer.parseInt(tk.nextToken());
            if (w == 0 && h == 0) break;

            int[][] map = new int[h][w];
            int count = 0;

            for (int i = 0; i < h; i++) {
                tk = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(tk.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        dfs(map, i, j);
                        count++;
                    }
                }
            }

            sb.append(count + "\n");
        }
        System.out.println(sb);
    }

    static void dfs(int[][] map, int x, int y) {
        map[x][y] = 0;

        for (int i = 0; i < 8; i++) {
            int XX = x + X[i];
            int YY = y + Y[i];
            if (XX >= h || YY >= w || XX < 0 || YY < 0) continue;
            if (map[XX][YY] == 0) continue;
            dfs(map, XX, YY);
        }

    }

}

package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num4963 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] X = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] Y = {0, -1, -1, -1, 0, 1, 1, 1};

        while (true) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(tk.nextToken());
            int h = Integer.parseInt(tk.nextToken());
            if (w == 0 && h == 0) break;
            int[][] map = new int[h][w];
            int[][] visited = new int[h][w];
            Queue<int[]> queue = new LinkedList<>();
            int count = 0;

            for (int i = 0; i < h; i++) {
                tk = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(tk.nextToken());
                }
            }

            for (int a = 0; a < h; a++) {
                for (int b = 0; b < w; b++) {
                    if (map[a][b] == 1 && visited[a][b] != 1) {
                        queue.add(new int[]{a, b});
                        visited[a][b] = 1;
                        count++;
                        while (!queue.isEmpty()) {
                            int[] numbers = queue.poll();
                            int x = numbers[0];
                            int y = numbers[1];
                            for (int i = 0; i < 8; i++) {
                                int xx = x + X[i];
                                int yy = y + Y[i];
                                if (xx >= 0 && xx < h && yy >= 0 && yy < w) {
                                    if (map[xx][yy] == 1 && visited[xx][yy] != 1) {
                                        queue.add(new int[]{xx,yy});
                                        visited[xx][yy] = 1;
                                    }
                                }
                            }
                        }
                    }
                }

            }
            sb.append(count + "\n");

        }
        System.out.println(sb);
    }
}

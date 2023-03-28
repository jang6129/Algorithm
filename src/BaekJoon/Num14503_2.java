package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Num14503_2 {

    static int[][] map;
    static int N, M, r, c, d;
    static int count = 0;
    static int[] X = {0, 1, 0, -1};
    static int[] Y = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        map = new int[N][M];
        tk = new StringTokenizer(br.readLine());
        r = Integer.parseInt(tk.nextToken());
        c = Integer.parseInt(tk.nextToken());
        d = Integer.parseInt(tk.nextToken());

        for (int a = 0; a < N; a++) {
            tk = new StringTokenizer(br.readLine());
            for (int b = 0; b < M; b++) {
                map[a][b] = Integer.parseInt(tk.nextToken());
            }
        }
        System.out.println(robot());
    }

    static int robot() {
        Stack<int[]> queue = new Stack<>();
        queue.add(new int[]{r, c, d});

        while (!queue.isEmpty()) {
            int[] arr = queue.pop();
            int x = arr[0];
            int y = arr[1];
            int d = arr[2];
            if (map[x][y] == 0) {
                map[x][y] = 2;
                count++;
            }
            int[] visited = new int[4];
            boolean flag = false;
            for (int i = d; i >= -1; i--) {
                if (i == -1) i = 3;
                if (visited[i] != 1) {
                    visited[i] = 1;
                } else break;
                int xx = x + X[i];
                int yy = y + Y[i];
                if (map[xx][yy] == 0) {
                    queue.add(new int[]{xx, yy, i});
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                int xx = x - X[d];
                int yy = y - Y[d];
                if (map[xx][yy] == 1) return count;
                else queue.add(new int[]{xx, yy, d});
            }

        }


        return count;
    }

}

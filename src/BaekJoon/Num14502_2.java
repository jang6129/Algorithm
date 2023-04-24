package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num14502_2 {
    static int N, M;
    static int[][] map;
    static ArrayList<int[]> empty = new ArrayList<>();
    static int[] X = {0, 1, 0, -1};
    static int[] Y = {1, 0, -1, 0};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tk.nextToken());
                if (map[i][j] == 0) empty.add(new int[]{i, j});
            }
        }

        for (int i = 0; i < empty.size(); i++) {
            for (int j = i + 1; j < empty.size(); j++) {
                for (int k = j + 1; k < empty.size(); k++) {
                    int[] a = empty.get(i);
                    int[] b = empty.get(j);
                    int[] c = empty.get(k);
                    max = Math.max(max, BFS(a, b, c));
                }
            }
        }

        System.out.println(max);
    }

    static int BFS(int[] a, int[] b, int[] c) {
        int[][] curMap = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                curMap[i][j] = map[i][j];
            }
        }

        curMap[a[0]][a[1]] = 1;
        curMap[b[0]][b[1]] = 1;
        curMap[c[0]][c[1]] = 1;

        Queue<int[]> q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (curMap[i][j] == 2 && !visited[i][j]) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int xx = cur[0] + X[k];
                            int yy = cur[1] + Y[k];
                            if (xx < 0 || yy < 0 || xx >= N || yy >= M) continue;
                            if (visited[xx][yy]) continue;
                            if (curMap[xx][yy] == 0) {
                                q.add(new int[]{xx, yy});
                                curMap[xx][yy] = 2;
                                visited[xx][yy] = true;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (curMap[i][j] == 0) count++;
            }
        }

        return count;
    }

}

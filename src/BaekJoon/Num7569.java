package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num7569 {
    static int M, N, H;
    static int[][][] box;
    static boolean[][][] visited;
    static int[] X = {0, 1, 0, -1, 0, 0};
    static int[] Y = {1, 0, -1, 0, 0, 0};
    static int[] Z = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        H = Integer.parseInt(tk.nextToken());

        box = new int[H][M][N];
        visited = new boolean[H][M][N];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                tk = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    box[i][j][k] = Integer.parseInt(tk.nextToken());
                }
            }
        }

        BFS();

    } // main ends

    static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        int day = 0;
        ArrayList<Integer> counter = new ArrayList<>();
        counter.add(0);

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (box[i][j][k] == 1 && !visited[i][j][k]) {
                        q.add(new int[]{i, j, k});
                        visited[i][j][k] = true;
                        counter.add(0, counter.get(0) + 1);
                    }
                }
            }
        }

        while (true) {
            int cur = counter.get(day);
            int count = 0;
            boolean flag = false;
            while (cur > 0) {
                int[] input = q.poll();
                cur--;
                for (int i = 0; i < 6; i++) {
                    int zz = input[0] + Z[i];
                    int xx = input[1] + X[i];
                    int yy = input[2] + Y[i];
                    if (zz < 0 || xx < 0 || yy < 0 || zz >= H || xx >= M || yy >= N) continue;
                    if (visited[zz][xx][yy]) continue;
                    if (box[zz][xx][yy] == 0) {
                        box[zz][xx][yy] = 1;
                        visited[zz][xx][yy] = true;
                        q.add(new int[]{zz, xx, yy});
                        count++;
                        flag = true;
                    }
                }
            }
            if (!flag) break;
            day++;
            counter.add(day, count);
        }

        boolean flag2 = false;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (box[i][j][k] == 0) {
                        flag2 = true;
                        break;
                    }
                }
            }
        }

        if (flag2) System.out.println(-1);
        else System.out.println(day);

    } // BFS ends

} // Class ends

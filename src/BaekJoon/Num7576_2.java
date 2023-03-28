package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.exit;
import static java.lang.System.getProperties;

public class Num7576_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int[] X = {1, 0, -1, 0};
        int[] Y = {0, -1, 0, 1};
        // 밭 크기 입력
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());
        int[][] farm = new int[M][N];
        Queue<int[]> q = new LinkedList<>();
        // 토마토 좌표 입력
        boolean flag = false;
        for (int a = 0; a < M; a++) {
            tk = new StringTokenizer(br.readLine());
            for (int b = 0; b < N; b++) {
                farm[a][b] = Integer.parseInt(tk.nextToken());
                if (farm[a][b] == 0) flag = true;
                else if (farm[a][b] == 1) q.add(new int[]{a, b, 0});
            }
        }
        // 모든 토마토가 익은 상태면 0 출력 후 프로그램 종료
        if (flag == false) {
            System.out.println(0);
            exit(0);
        }
        // BFS
        int days = 0;
        while (!q.isEmpty()) {
            int[] n = q.poll();
            int x = n[0];
            int y = n[1];
            int day = n[2];
            if (day > days) days = day;
            // 동서남북 반복
            for (int a = 0; a < 4; a++) {
                int xx = x + X[a];
                int yy = y + Y[a];
                if (xx >= 0 && xx < M && yy >= 0 && yy < N) {
                    if (farm[xx][yy] == 0) {
                        farm[xx][yy] = 1;
                        q.add(new int[]{xx, yy, day + 1});
                    }
                }
            }
        }
        boolean undone = false;
        for (int a = 0; a < M; a++) {
            for (int b = 0; b < N; b++) {
                if (farm[a][b] == 0) undone = true;
            }
        }

        if (undone) {
            System.out.println(-1);
            exit(0);
        } else System.out.println(days);
    }
}

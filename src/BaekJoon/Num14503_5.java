package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Num14503_5 {
    static int[][] map;
    static int[] X = {1, 0, -1, 0};
    static int[] Y = {0, -1, 0, 1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 방 크기 입력
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());
        // 청소기 좌표, 방향 입력
        tk = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(tk.nextToken());
        int c = Integer.parseInt(tk.nextToken());
        int d = Integer.parseInt(tk.nextToken());
        // 반복 돌며 벽, 칸 입력
        map = new int[N][M];
        for (int a = 0; a < N; a++) {
            tk = new StringTokenizer(br.readLine());
            for (int b = 0; b < M; b++) {
                map[a][b] = Integer.parseInt(tk.nextToken());
            }
        }
        // queue에 첫 좌표 삽입
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c, d});
        // BFS 시작
        while (!queue.isEmpty()) {
            int[] numbers = queue.poll();
            int x = numbers[0];
            int y = numbers[1];
            int direction = numbers[2];

            if (map[x][y] == 0) {
                map[x][y] = 2;
                count++;
            }

            // direction 부터 4칸 시계 역순으로 검색
            int[] checker = new int[4];
            boolean flag = false;
            for (int i = direction; i >= -1; i--) {
                // 4방향 다 돌기 전에 -1까지 들어가면 3으로 바꿔주기
                if (i == -1) i = 3;
                if (checker[i] == 1) break;
                checker[i] = 1;
                int xx = x + X[i];
                int yy = y + Y[i];
                // 앞이 빈 칸이면 재귀 돌아주기
                if (map[xx][yy] == 0) {
                    queue.add(new int[]{xx, yy, i});
                    flag = true;
                }
            }
            if (flag == false) {
                int xx = x - X[direction];
                int yy = y - Y[direction];
                if (map[xx][yy] == 1) {
                    System.out.println(count);
                    exit(0);
                } else {
                    queue.add(new int[]{xx, yy, direction});
                }
            }

        }


    }
}

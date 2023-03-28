package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num2468_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] X = {1, 0, -1, 0};
        int[] Y = {0, -1, 0, 1};
        // 지역 크기 N 입력
        int N = Integer.parseInt(br.readLine());
        // N x N 좌표별 높이 입력, 최대 높이 입력
        int[][] map = new int[N][N];
        int max = 1;
        for (int a = 0; a < N; a++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            for (int b = 0; b < N; b++) {
                map[a][b] = Integer.parseInt(tk.nextToken());
                if (map[a][b] > max) max = map[a][b];
            }
        }

        // 최대 높이 - 1 까지 안전지대 계산하며 answer과 비교하여 최댓값 구하기
        int answer = 0;
        for (int a = 0; a < max; a++) {
            Queue<int[]> queue = new LinkedList<>();
            int[][] visited = new int[N][N];
            int count = 0;
            // N x N 안전지대 완전탐색으로 검색
            for (int b = 0; b < N; b++) {
                for (int c = 0; c < N; c++) {
                    // queue에 미방문 안전지대 입력
                    if (map[b][c] > a && visited[b][c] != 1) {
                        queue.add(new int[]{b,c});
                        count++;
                        visited[b][c] = 1;
                        // BFS 시작
                        while (!queue.isEmpty()) {
                            int[] number = queue.poll();
                            // 동서남북 돌기
                            for (int d = 0; d < 4; d++) {
                                int xd = number[0] + X[d];
                                int yd = number[1] + Y[d];
                                // map 안에 있는지 확인
                                if (xd >= 0 && xd < N && yd >= 0 && yd < N) {
                                    if (map[xd][yd] > a && visited[xd][yd] != 1) {
                                        queue.add(new int[]{xd, yd});
                                        visited[xd][yd] = 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (count > answer) answer = count;
        }
        System.out.println(answer);
    }
}

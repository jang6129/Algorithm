package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num1012_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] X = {1, 0, -1, 0};
        int[] Y = {0, -1, 0, 1};
        // 테스트 케이스 수 입력
        int T = Integer.parseInt(br.readLine());
        // T만큼 반복
        for (int i = 0; i < T; i++) {
            // 가로 길이, 세로 길이, 배추 수 입력
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(tk.nextToken());
            int N = Integer.parseInt(tk.nextToken());
            int K = Integer.parseInt(tk.nextToken());
            int[][] cabbage = new int[M][N];
            // 배추 좌표 입력 K만큼 반복
            for (int a = 0; a < K; a++) {
                tk = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(tk.nextToken());
                int y = Integer.parseInt(tk.nextToken());
                cabbage[x][y] = 1;
            }
            // 좌표 Queue, visited 변수 생성
            Queue<int[]> queue = new LinkedList<>();
            int[][] visited = new int[M][N];
            int count = 0;
            // BFS 시작
            for (int a = 0; a < M; a++) {
                for (int b = 0; b < N; b++) {
                    // 배추밭 완전탐색, 방문하지 않은 배추 발견 시 Queue에 투입
                    if (cabbage[a][b] == 1 && visited[a][b] != 1) {
                        queue.add(new int[]{a, b});
                        count++;
                        visited[a][b] = 1;
                        // 동서남북 순으로 검색하여 위 과정 반복
                        while (!queue.isEmpty()) {
                            int[] number = queue.poll();
                            for (int c = 0; c < 4; c++) {
                                int xc = number[0] + X[c];
                                int yc = number[1] + Y[c];
                                // array를 벗어나지 않는지 체크
                                if (xc >= 0 && xc < M && yc >= 0 && yc < N) {
                                    if (cabbage[xc][yc] == 1 && visited[xc][yc] != 1) {
                                        queue.add(new int[]{xc, yc});
                                        visited[xc][yc] = 1;
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

package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Num2667 {
    // 집의 수를 담는 ArrayList
    static ArrayList<Integer> amounts = new ArrayList<>();
    // 지도
    static int[][] map;
    static int N;
    // visited
    static boolean[][] visited;
    // 조향장치
    static int[] X = {1, 0, -1, 0};
    static int[] Y = {0, 1, 0, -1};
    // 집의 수를 세주는 변수
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 지도 크기 입력
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        // 지도 입력
        for (int i = 0; i < N; i++) {
            String tk = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = tk.charAt(j) - '0';
            }
        }


        // DFS에 좌표 넣어주기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    count = 0;
                    DFS(i, j);
                    amounts.add(count);
                }
            }
        }

        // 단지수 정렬
        Collections.sort(amounts);

        sb.append(amounts.size() + "\n");

        for (int i : amounts) {
            sb.append(i + "\n");
        }

        System.out.println(sb);
    }

    static void DFS(int x, int y) {
        visited[x][y] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int xx = x + X[i];
            int yy = y + Y[i];
            if (xx < 0 || yy < 0 || xx >= N || yy >= N) continue;
            if (visited[xx][yy]) continue;
            if (map[xx][yy] != 1) continue;
            DFS(xx, yy);
        }
    }


}

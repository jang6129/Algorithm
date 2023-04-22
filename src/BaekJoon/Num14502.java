package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num14502 {

    static int N, M;
    static int max = Integer.MIN_VALUE;
    static boolean[][] visited;
    static int[] X = {0, 1, 0, -1};
    static int[] Y = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());

        int[][] map = new int[N][M];
        List<int[]> emptyRoom = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tk.nextToken());
                if (map[i][j] == 0) emptyRoom.add(new int[]{i, j});
            }
        }

        int size = emptyRoom.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    max = Math.max(max, BFS(map, emptyRoom.get(i), emptyRoom.get(j), emptyRoom.get(k)));
                }
            }
        }

        System.out.println(max);
    }

    static int BFS(int[][] map, int[] wallA, int[] wallB, int[] wallC) {
        map[wallA[0]][wallA[1]] = 1;
        map[wallB[0]][wallB[1]] = 1;
        map[wallC[0]][wallC[1]] = 1;

        visited = new boolean[N][M];
        int[][] curMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                curMap[i][j] = map[i][j];
            }
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (curMap[i][j] == 2 && !visited[i][j]) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] input = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int xx = input[0] + X[k];
                            int yy = input[1] + Y[k];
                            if (xx < 0 || yy < 0 || xx >= N || yy >= M) continue;
                            if (curMap[xx][yy] == 0) {
                                curMap[xx][yy] = 2;
                                visited[xx][yy] = true;
                                q.add(new int[]{xx, yy});
                            }
                        }
                    }
                }
            }
        }

        int counter = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) counter++;
            }
        }

        return counter;
    } // BFS() ends

}

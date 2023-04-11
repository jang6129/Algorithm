package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int cityN = Integer.parseInt(tk.nextToken());
        int roadN = Integer.parseInt(tk.nextToken());
        int distance = Integer.parseInt(tk.nextToken());
        int startingCity = Integer.parseInt(tk.nextToken());
        StringBuilder sb = new StringBuilder();

        int[][] map = new int[cityN + 1][cityN + 1];
        for (int i = 0; i < roadN; i++) {
            tk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tk.nextToken());
            int y = Integer.parseInt(tk.nextToken());

            map[x][y] = 1;
        }

        boolean flag = false;

        for (int i = 1; i <= cityN; i++) {
            Queue<int[]> q = new LinkedList<>();
            boolean visited[] = new boolean[cityN + 1];
            if (map[startingCity][i] == 1) {
                q.add(new int[] {i, 1});
                visited[i] = true;
                if (distance == 1) {
                    sb.append(i + "\n");
                    flag = true;
                    continue;
                }
                while (!q.isEmpty()) {
                    int[] input = q.poll();
                    int n = input[0];
                    int count = input[1];
                    if (count == distance) {
                        sb.append(n + "\n");
                        flag = true;
                    }
                    for (int j = 1; j <= cityN; j++) {
                        if (map[n][j] == 1 && !visited[j]) {
                            q.add(new int[] {j, count + 1});
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        if (!flag) System.out.println(-1);
        else System.out.println(sb);
    }
}

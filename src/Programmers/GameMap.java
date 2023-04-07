package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class GameMap {

    static int[] X = {1, 0, -1, 0};
    static int[] Y = {0, 1, 0, -1};
    static int answer;

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        BFS(maps);
        System.out.println(answer);
    }

    static void BFS(int[][] maps) {
        int row = maps.length;
        int column = maps[0].length;
        boolean[][] visited = new boolean[row][column];

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0, 1});

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int x = arr[0];
            int y = arr[1];
            int count = arr[2];
            if (x == maps.length - 1 && y == maps[0].length - 1) {
                answer = count;
                break;
            }
            boolean flag = false;
            for (int i = 0; i < 4 ;i++) {
                int xx = x + X[i];
                int yy = y + Y[i];
                if (xx < 0 || yy < 0 || xx >= row || yy >= column) continue;
                if (visited[xx][yy] || maps[xx][yy] == 0) continue;
                q.add(new int[]{xx, yy, count + 1});
                visited[xx][yy] = true;
                flag = true;
            }
            if (!flag) answer = -1;
        }

    }


} // class ends

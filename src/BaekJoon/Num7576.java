package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int[] xD = {1, -1, 0, 0};
        int[] yD = {0, 0, 1, -1};

        int width = Integer.parseInt(tk.nextToken());
        int height = Integer.parseInt(tk.nextToken());
        int[][] farm = new int[height][width];

        for (int i = 0; i < height; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                farm[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        Queue<Coordinate> q = new LinkedList<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (farm[i][j] == 1)
                    q.add(new Coordinate(i, j, 0));
            }
        }

        int day = 0;

        while (!q.isEmpty()) {
            Coordinate coordinate = q.poll();
            int x = coordinate.x;
            int y = coordinate.y;
            day = coordinate.day;

            for (int i = 0; i < 4; i++) {
                int newX = x + xD[i];
                int newY = y + yD[i];
                if (newX >= 0 && newX < height && newY >= 0 && newY < width) {
                    if (farm[newX][newY] == 0) {
                        farm[newX][newY] = 1;
                        q.add(new Coordinate(newX, newY, day + 1));
                    }
                }
            }
        }

        int flag = 1;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (farm[i][j] == 0) {
                    flag = 0;
                    break;
                }
            }
        }

        if (flag == 1) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    public static class Coordinate {
        int x;
        int y;
        int day;

        public Coordinate(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}

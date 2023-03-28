package Test;

import BaekJoon.Num7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class samsung1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] x = {1, 0, -1, 0};
        int[] y = {0, -1, 0, 1};

        int T = Integer.parseInt(br.readLine());

        for (int a = 0; a < T; a++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(tk.nextToken());
            int C = Integer.parseInt(tk.nextToken());
            String[][] map = new String[R][C];
            for (int b = 0; b < R; b++) {
                String input = br.readLine();
                for (int c = 0; c < C; c++) {
                    map[b][c] = Character.toString(input.charAt(c));
                }
            }
            int max = 0;
            Coordinate coordinate = new Coordinate(0, 0, 1);
            Queue<Coordinate> queue = new LinkedList<>();
            queue.add(coordinate);
            HashSet<String> checker = new HashSet<>();
            int[][] flag = new int[R][C];
            while (!queue.isEmpty()) {
                coordinate = queue.poll();
                int xCoordinate = coordinate.x;
                int yCoordinate = coordinate.y;
                int counter = coordinate.count;
                checker.add(map[xCoordinate][yCoordinate]);
                flag[xCoordinate][yCoordinate] = 1;
                if (counter > max) {
                    max = counter;
                }
                for (int i = 0; i < 4; i++) {
                    if (xCoordinate + x[i] >= 0 && yCoordinate + y[i] >= 0 &&
                            xCoordinate + x[i] < R && yCoordinate + y[i] < C &&
                            !checker.contains(map[xCoordinate + x[i]][yCoordinate + y[i]]) &&
                            flag[xCoordinate + x[i]][yCoordinate + y[i]] != 1)
                        queue.add(new Coordinate(xCoordinate + x[i], yCoordinate + y[i], ++counter));
                }
            }
            sb.append("#" + (a + 1) + " " + max + "\n");
        }

        System.out.println(sb);
    }

    public static class Coordinate {
        int x, y;
        int count = 0;

        public Coordinate(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

}

package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ssafy1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int gridN = Integer.parseInt(tk.nextToken());
        int dotN = Integer.parseInt(tk.nextToken());

        int[][] grid = new int[gridN + 1][gridN + 1];

        int xTop = 0;
        int xDown = Integer.MAX_VALUE;
        int yM = 0;

        for (int i = 0; i < dotN; i++) {
            tk = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(tk.nextToken());
            int x = Integer.parseInt(tk.nextToken());
            grid[y][x] = 1;
            if (x > xTop) {
                xTop = x;
            }
            if (x < xDown) {
                xDown = x;
            }
            if (y > yM) {
                yM = y;
            }
        }

        if (xDown < gridN - xTop) {
            System.out.println(yM + gridN - xTop - 1);
        } else {
            System.out.println(yM + xDown - 1);
        }

    }

//    public static class Coordinate {
//        int x;
//        int y;
//        public Coordinate(int y, int x) {
//            this.x = x;
//            this.y = y;
//        }
//    }
}

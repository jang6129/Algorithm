package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Num8911 {

    static ArrayList<Integer> xStack = new ArrayList<>();
    static ArrayList<Integer> yStack = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        Direction d = new Direction(0, 1);
        Coordinate c = new Coordinate(0, 0);

        for (int a = 0; a < T; a++) {
            String input = br.readLine();
            String[] tokens = input.split("");
            for (int b = 0; b < input.length(); b++) {
                String command = tokens[b];
                if (command == "F") {
                    F(d, c);
                } else if (command == "B") {
                    B(d, c);
                } else if (command == "L") {
                    L(d);
                } else {
                    R(d);
                }
            }

            Collections.sort(xStack);
            Collections.sort(yStack);

            if (xStack.size() < 1 || yStack.size() < 1) {
                sb.append(0 + "\n");
            } else {
                int minX = xStack.get(0);
                int minY = yStack.get(0);
                int maxX = xStack.lastIndexOf(xStack);
                int maxY = yStack.lastIndexOf(yStack);

                int xLength = Math.abs(minX) + Math.abs(maxX);
                int yLength = Math.abs(minY) + Math.abs(maxY);
                sb.append(xLength * yLength + "\n");
            }
        }
        System.out.println(sb);
    }

    public static void F(Direction d, Coordinate c) {
        c.x += d.x;
        xStack.add(c.x);
        c.y += d.y;
        yStack.add(c.y);
    }

    public static void B(Direction d, Coordinate c) {
        c.x -= d.x;
        xStack.add(c.x);
        c.y -= d.x;
        yStack.add(c.y);
    }

    public static void L(Direction d) {
        if (d.x == 0 && d.y == 1) {
            d.x = 1;
            d.y = 0;
        } else if (d.x == 1 && d.y == 0) {
            d.x = 0;
            d.y = -1;
        } else if (d.x == 0 && d.y == -1) {
            d.x = -1;
            d.y = 0;
        } else {
            d.x = 0;
            d.y = 1;
        }
    }

    public static void R(Direction d) {
        if (d.x == 0 && d.y == 1) {
            d.x = -1;
            d.y = 0;
        } else if (d.x == -1 && d.y == 0) {
            d.x = 0;
            d.y = -1;
        } else if (d.x == 0 && d.y == -1) {
            d.x = 1;
            d.y = 0;
        } else {
            d.x = 0;
            d.y = 1;
        }
    }

    public static class Direction {
        public int x = 0;
        public int y = 1;

        public Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Coordinate {
        public int x = 0;
        public int y = 0;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}





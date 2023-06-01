package BaekJoon;

import java.util.*;
import java.io.*;

public class Num15686_ex {
    static int N, M;
    static ArrayList<Point> home, chicken;
    static Point[] selected;
    static int result = Integer.MAX_VALUE;

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        selected = new Point[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) home.add(new Point(i, j));
                else if (value == 2) chicken.add(new Point(i, j));
            }
        }

        combination(0, 0);
        System.out.println(result);
    }

    static void combination(int cnt, int start) {
        if (cnt == M) {
            calculate();
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            selected[cnt] = chicken.get(i);
            combination(cnt + 1, i + 1);
        }
    }

    static void calculate() {
        int total = 0;
        for (Point h : home) {
            int min = Integer.MAX_VALUE;
            for (Point s : selected) {
                int distance = Math.abs(h.r - s.r) + Math.abs(h.c - s.c);
                min = Math.min(min, distance);
            }
            total += min;
        }
        result = Math.min(result, total);
    }
}

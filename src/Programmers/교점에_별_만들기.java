package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 교점에_별_만들기 {
    private static class Point {
        public final long x, y;
        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);
        if (x % 1 != 0 || y % 1 != 0) return null;
        return new Point((long) x, (long) y);
    }

    private Point getMinimumPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        for (Point p : points) {
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }
        return new Point(x, y);
    }

    private Point getMaximumPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        for (Point p : points) {
            if (p.x > x) x = p.x;
            if (p.y > y) y = p.y;
        }
        return new Point(x, y);
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }
        Point minimum = getMinimumPoint(points);
        Point maximum = getMaximumPoint(points);
        int width = (int) (maximum.x - minimum.x + 1);
        int height = (int) (maximum.y - minimum.y + 1);
        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }
        for (Point p : points) {
            int x = (int) (p.x - minimum.x);
            int y = (int) (maximum.y - p.y);
            arr[y][x] = '*';
        }
        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }
        return result;
    }

}

//import java.util.*;
//
//class Solution {
//
//    static int maxX = Integer.MIN_VALUE;
//    static int maxY = Integer.MIN_VALUE;
//    static int minX = Integer.MAX_VALUE;
//    static int minY = Integer.MAX_VALUE;
//
//    static class Point {
//        int x, y;
//        Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    static Point intersection(int a1, int b1, int c1, int a2, int b2, int c2) {
//        int denominator = a1 * b2 - a2 * b1;
//        if (denominator == 0) {
//            return null;
//        }
//        double x = (double) ((b1 * c2) - (2 * c1)) / denominator;
//        double y = (double) ((c1 * a2) - (c2 * a1)) / denominator;
//
//        if (Math.abs(x) % 1 > 0 || Math.abs(y) % 1 > 0) return null;
//        maxX = Math.max(maxX, (int)x);
//        minX = Math.min(minX, (int)x);
//        maxY = Math.max(maxY, (int)y);
//        minY = Math.min(minY, (int)y);
//        return (new Point((int)x, (int)y));
//    }
//
//    public String[] solution(int[][] line) {
//        List<Point> list = new ArrayList<>();
//
//        for (int i = 0; i < line.length; i++) {
//            for (int j = i + 1; j < line.length; j++) {
//                Point point = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
//                if (point != null) list.add(point);
//            }
//        }
//
//        int r = maxY - minY + 1;
//        int c = maxX - minX + 1;
//
//        char[][] arr = new char[r][c];
//        for (char[] e : arr) {
//            Arrays.fill(e, '.');
//        }
//
//        for (Point p : list) {
//            arr[-p.y + maxY][p.x - minX] = '*';
//        }
//
//        String[] answer = new String[arr.length];
//        for (int i = 0; i < answer.length; i++) {
//            answer[i] = new String(arr[i]);
//        }
//
//        return answer;
//    }
//}
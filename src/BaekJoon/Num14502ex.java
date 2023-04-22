//package BaekJoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Num14502ex {
//    // ...
//    static int N, M;
//    static int max = Integer.MIN_VALUE;
//    static int[] X = {0, 1, 0, -1};
//    static int[] Y = {1, 0, -1, 0};
//
//    public static void main(String[] args) throws IOException {
//        // ...
//        for (int i = 0; i < size; i++) {
//            for (int j = i + 1; j < size; j++) {
//                for (int k = j + 1; k < size; k++) {
//                    max = Math.max(max, BFS(map, emptyRoom.get(i), emptyRoom.get(j), emptyRoom.get(k)));
//                }
//            }
//        }
//
//        System.out.println(max);
//    }
//
//    static int BFS(int[][] map, int[] wallA, int[] wallB, int[] wallC) {
//        boolean[][] visited = new boolean[N][M]; // 매번 새로운 visited 배열을 사용하도록 이동
//
//        map[wallA[0]][wallA[1]] = 1;
//        map[wallB[0]][wallB[1]] = 1;
//        map[wallC[0]][wallC[1]] = 1;
//
//        // ...
//
//        // BFS가 끝난 후 map을 원래 상태로 되돌립니다.
//        resetMap(map, wallA, wallB, wallC);
//
//        return counter;
//    } // BFS() ends
//
//    static void resetMap(int[][] map, int[] wallA, int[] wallB, int[] wallC) {
//        map[wallA[0]][wallA[1]] = 0;
//        map[wallB[0]][wallB[1]] = 0;
//        map[wallC[0]][wallC[1]] = 0;
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if (map[i][j] == 2) {
//                    map[i][j] = 0;
//                }
//            }
//        }
//    }
//}
//
//}

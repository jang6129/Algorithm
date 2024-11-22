package BaekJoon.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 스도쿠 {

    // 행, 열, 3x3을 검사한다.
    // 0의 위치를 찾는다.
    // 숫자를 다 넣어본다.
    // 최초 0 개수만큼 쌓이면 스도쿠를 완성했는지 검사한다.
    // 완성된 경우 프린트

    static int[][] map = new int[9][9];
    static List<int[]> zeroList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // map, zeroList 초기화
        for (int i = 0; i < 9; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 0) {
                    zeroList.add(new int[]{i, j});
                }
            }
        }

        recur(0);
    }

    public static void recur(int depth) {
        if (depth == zeroList.size()) {
            if (isSudoku()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        sb.append(map[i][j]).append(" ");
                    }
                    sb.append("\n");
                }
                System.out.println(sb);
            }
            return;
        }

        int[] zero = zeroList.get(depth);
        int x = zero[0];
        int y = zero[1];

        for (int i = 1; i <= 9; i++) {
            if (check(x, y, i)) {
                map[x][y] = i;
                recur(depth + 1);
                map[x][y] = 0;
            }
        }
    } // recur() ends

    static boolean check(int x, int y, int num) {
        // 가로, 세로 체크
        for (int i = 0; i < 9; i++) {
            if ((i != y && map[x][i] == num)|| (i != x && map[i][y] == num)) {
                return false;
            }
        }
        // 3x3 체크
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (map[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isSudoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!check(i, j, map[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

}

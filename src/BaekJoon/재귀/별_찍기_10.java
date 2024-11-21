package BaekJoon.재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 별_찍기_10 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], '*');
        }
        star(map, 0, 0, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void star(char[][] map, int x, int y, int n) {
        if (n == 1) return;
        int divider = n / 3;

        for (int i = x + divider; i < x + 2 * divider; i++) {
            for (int j = y + divider; j < y + 2 * divider; j++) {
                map[i][j] = ' ';
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) continue;
                star(map, x + i * divider, y + j * divider, divider);
            }
        }
    }
}
package Programmers;

import java.util.*;
class 삼각_달팽이 {
    public int[] solution(int n) {
        int[] rD = {1, 0, -1};
        int[] cD = {0, 1, -1};
        int d = 0;

        int[][] arr = new int[n+1][n+1];
        int count = 1;

        int r = 1;
        int c = 1;

        while (true) {
            arr[r][c] = count++;
            int rr = r + rD[d];
            int cc = c + cD[d];

            if (rr == 0 || cc == 0 || rr == n + 1 || cc == n + 1 || arr[rr][cc] != 0) {
                d = (d + 1) % 3;
                rr = r + rD[d];
                cc = c + cD[d];
                if (rr == 0 || cc == 0 || rr == n + 1 || cc == n + 1 || arr[rr][cc] != 0) break;
            }

            r = rr;
            c = cc;
        }

        int[] answer = new int[count - 1];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                answer[index++] = arr[i][j];
            }
        }

        return answer;
    } // solution() ends
}
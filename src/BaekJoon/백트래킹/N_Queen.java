package BaekJoon.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

// 매번 새 map을 그려주고 퀸을 하나씩 찍어본다.
// 퀸을 찍을 때마다 가로, 세로, 대각선을 체크한다.
// 가로, 세로, 대각선을 체크하는 방법은 1. 가로, 세로는 map의 행, 열을 체크하면 된다.

public class N_Queen {

    static int[][] map;
    static int n;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        recur(0);

        System.out.println(count);
    }

    public static void recur(int depth) {
        if (depth == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check(depth, i)) {
                map[depth][i] = 1;
                recur(depth + 1);
                map[depth][i] = 0;
            }
        }
    }

    public static boolean check(int x, int y) {
        for (int i = 0; i < n; i++) {
            // 가로, 세로 체크
            if (map[x][i] == 1 || map[i][y] == 1) {
                return false;
            }
            // 대각선 체크
            if (x + i < n && y + i < n && map[x + i][y + i] == 1) {
                return false;
            }
            if (x - i >= 0 && y - i >= 0 && map[x - i][y - i] == 1) {
                return false;
            }
            if (x + i < n && y - i >= 0 && map[x + i][y - i] == 1) {
                return false;
            }
            if (x - i >= 0 && y + i < n && map[x - i][y + i] == 1) {
                return false;
            }
        }
        return true;
    }

}

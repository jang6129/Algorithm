package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num23747 {

    static int R, C;
    static char[][] map;
    static char[][] warded;
    static int[] rD = {-1, 0, 1, 0};
    static int[] cD = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk = new StringTokenizer(br.readLine());

        R = Integer.parseInt(tk.nextToken());
        C = Integer.parseInt(tk.nextToken());

        map = new char[R][C];
        warded = new char[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                warded[i][j] = '#';
            }
        }

        for (int i = 0; i < R; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = input[j];
            }
        }

        tk = new StringTokenizer(br.readLine());

        int rPointer = Integer.parseInt(tk.nextToken()) - 1;
        int cPointer = Integer.parseInt(tk.nextToken()) - 1;

        char[] cmd = br.readLine().toCharArray();

        for (char c : cmd) {
            if (c == 'W') {
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[] {rPointer, cPointer});
                warded[rPointer][cPointer] = '.';
                char target = map[rPointer][cPointer];
                while (!q.isEmpty()) {
                    int[] pointer = q.poll();
                    int curR = pointer[0];
                    int curC = pointer[1];
                    for (int i = 0; i < 4; i++) {
                        int rr = curR + rD[i];
                        int cc = curC + cD[i];
                        if (rr < 0 || cc < 0 || rr >= R || cc >= C) continue;
                        if (warded[rr][cc] == '.') continue;
                        if (map[rr][cc] == target) {
                            q.add(new int[] {rr, cc});
                            warded[rr][cc] = '.';
                        }
                    }
                }
            } else if (c == 'U') {
                rPointer += rD[0];
                cPointer += cD[0];
            } else if (c == 'R') {
                rPointer += rD[1];
                cPointer += cD[1];
            } else if (c == 'D') {
                rPointer += rD[2];
                cPointer += cD[2];
            } else if (c == 'L') {
                rPointer += rD[3];
                cPointer += cD[3];
            }
        }

        warded[rPointer][cPointer] = '.';

        for (int i = 0; i < 4; i++) {
            int rr = rPointer + rD[i];
            int cc = cPointer + cD[i];
            if (rr < 0 || cc < 0 || rr >= R || cc >= C) continue;
            if (warded[rr][cc] == '.') continue;
            warded[rr][cc] = '.';
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(warded[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

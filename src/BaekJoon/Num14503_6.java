package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num14503_6 {

    static int[] rowD = {-1, 0, 1, 0};
    static int[] colD = {0, 1, 0, -1};
    static int d = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // input 1
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(tk.nextToken());
        int colSize = Integer.parseInt(tk.nextToken());

        int[][] map = new int[rowSize][colSize];

        // input 2
        tk = new StringTokenizer(br.readLine());
        int curRow = Integer.parseInt(tk.nextToken());
        int curCol = Integer.parseInt(tk.nextToken());
        int d = Integer.parseInt(tk.nextToken());
        int answer = 0;

        for (int i = 0; i < rowSize; i++) {
            // input 3 ~
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < colSize; j++) {
                map[i][j] = Integer.parseInt(tk.nextToken());
//                System.out.println(map[i][j]);
            }
        }

        while (true) {
            if (map[curRow][curCol] == 0) {
                map[curRow][curCol] = -1;
                answer++;
            }

            boolean isCleaned = true;

            for (int i = 0; i < 4; i++) {
                if (d == 0) d = 3;
                else d--;

                int nextRow = curRow + rowD[d];
                int nextCol = curCol + colD[d];

                if (map[nextRow][nextCol] == 0) {
                    curRow = nextRow;
                    curCol = nextCol;
                    isCleaned = false;
                    break;
                }
            }

            if (!isCleaned) continue;
            int nextRow = curRow - rowD[d];
            int nextCol = curCol - colD[d];
            if (map[nextRow][nextCol] == 1) break;
            else {
                curRow = nextRow;
                curCol = nextCol;
            }
        }

        System.out.println(answer);
    }
}

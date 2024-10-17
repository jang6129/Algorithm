package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 최댓값 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[9][9];

        int max = 0;
        int x = 0;
        int y = 0;

        for (int i = 0; i < 9; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] > max) {
                    max = map[i][j];
                    x = i + 1;
                    y = j + 1;
                }
            }
        }

        if (max == 0) {
            System.out.println(max);
            System.out.println(1 + " " + 1);
        } else {
            System.out.println(max);
            System.out.println(x + " " + y);
        }


    }

}

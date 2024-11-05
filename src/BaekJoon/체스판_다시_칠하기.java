package BaekJoon;

import java.util.Scanner;

public class 체스판_다시_칠하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        char[][] boardW = new char[8][8];
        char[][] boardB = new char[8][8];
        char[][] board = new char[a][b];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    boardW[i][j] = 'W';
                    boardB[i][j] = 'B';
                } else {
                    boardW[i][j] = 'B';
                    boardB[i][j] = 'W';
                }
            }
        }

        for (int i = 0; i < a; i++) {
            String s = sc.next();
            for (int j = 0; j < b; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= a - 8; i++) {
            for (int j = 0; j <= b - 8; j++) {
                int cntW = 0;
                int cntB = 0;
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (board[i + k][j + l] != boardW[k][l]) {
                            cntW++;
                        }
                        if (board[i + k][j + l] != boardB[k][l]) {
                            cntB++;
                        }
                    }
                }
                min = Math.min(min, Math.min(cntW, cntB));
            }
        }

        System.out.println(min);
    }
}

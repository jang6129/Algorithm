package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num11724 {

    static int[][] arr;
    static int N, M;
    static int[] checker;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        arr = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(tk.nextToken());
            int column = Integer.parseInt(tk.nextToken());
            arr[row][column] = arr[column][row] = 1;
        }

        checker = new int[N + 1];
        int counter = 0;

        for (int i = 1; i <= N; i++) {
            if (checker[i] != 1) counter++;
            dfs(i);
        }

        System.out.println(counter);
    }

    static void dfs(int number) {
        checker[number] = 1;

        for (int i = 1; i <= N; i++) {
            if (arr[number][i] == 1 && checker[i] != 1) {
                System.out.println("- RECURSIVE -");
                dfs(i);
            }
        }
    }

}

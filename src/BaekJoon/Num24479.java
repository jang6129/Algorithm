package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num24479 {

    static StringBuilder sb = new StringBuilder();
    static int[][] connection;
    static int[] checker;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int nodeN = Integer.parseInt(tk.nextToken());
        int lineN = Integer.parseInt(tk.nextToken());
        int startingN = Integer.parseInt(tk.nextToken());

        connection = new int[nodeN + 1][nodeN + 1];
        checker = new int[nodeN + 1];

        for (int i = 0; i < lineN; i++) {
            tk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());

            connection[a][b] = 1;
            connection[b][a] = 1;
        }

        DFS(startingN);

        for (int i = 1; i < checker.length; i++) {
            if (checker[i] != 1) {
                sb.append(0 + "\n");
            }
        }

        System.out.println(sb.toString());
    }

    static void DFS(int startingN) {
        sb.append(startingN + "\n");
        checker[startingN] = 1;

        for (int i = 1; i < connection.length; i++) {
            if (connection[startingN][i] == 1 && checker[i] != 1) {
                DFS(i);
            }
        }
    }

}
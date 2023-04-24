package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num7569 {
    static int M,N,H;
    static int[][][] box;
    static int[] X = {0, 1, 0, -1, 0, 0};
    static int[] Y = {1, 0, -1, 0, 0, 0};
    static int[] Z = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        M = Integer.parseInt(tk.nextToken());
        N = Integer.parseInt(tk.nextToken());
        H = Integer.parseInt(tk.nextToken());

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                tk = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    box[i][j][k] = Integer.parseInt(tk.nextToken());
                }
            }
        }



    }
}

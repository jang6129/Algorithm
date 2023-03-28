package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(tk.nextToken());
        int N = Integer.parseInt(tk.nextToken());
        int[] arr = new int[K];
        int total = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }

        int start = 1;
        int end = total / N;

        while (start < end) {
            int mid = start + end / 2;
            int lines = 0;

            for (int i = 0; i < K; i++) {
                lines += arr[i] / mid;
            }
            if (lines < N) {

            }
        }


    }
}

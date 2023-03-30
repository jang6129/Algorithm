package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());

        tk = new StringTokenizer(br.readLine());

        int[] day = new int[N];

        for (int i = 0; i < N; i++) {
            day[i] = Integer.parseInt(tk.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += day[i];

            if (i < K) max = sum;

            if (i >= K) {
                sum -= day[i - K];
                max = Math.max(max, sum);
            }
        }

        System.out.println(max);

    }
}

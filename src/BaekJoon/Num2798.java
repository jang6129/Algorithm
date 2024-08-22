package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int N, TargetNumber;
        N = Integer.parseInt(tk.nextToken());
        TargetNumber = Integer.parseInt(tk.nextToken());

        int[] cards = new int[N];

        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(tk.nextToken());
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum > answer && sum <= TargetNumber) {
                        answer = sum;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}

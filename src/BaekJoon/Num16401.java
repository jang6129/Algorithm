package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int peopleN = Integer.parseInt(tk.nextToken());
        int snackN = Integer.parseInt(tk.nextToken());
        int[] snacks = new int[snackN];

        tk = new StringTokenizer(br.readLine());

        int max = 0;

        for (int i = 0; i < snackN; i++) {
            snacks[i] = Integer.parseInt(tk.nextToken());

            if (snacks[i] > max) {
                max = snacks[i];
            }
        }

        int start = 0;
        int end = max;
        int result = 0;

        while (end >= start) {
            int mid = (start + end) / 2;
            int counter = 0;

            if (mid == 0) {
                result = 0;
                break;
            }

            for (int i = 0; i < snackN; i++) {
                counter += snacks[i] / mid;
            }

            if (counter < peopleN) {
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}

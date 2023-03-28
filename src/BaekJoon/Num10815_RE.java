package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num10815_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer tk = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        tk = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(tk.nextToken());
            int start = 0;
            int end = N - 1;
            boolean checker = false;

            while (start <= end) {
                int mid = (start + end) / 2;
                if (arr[mid] > number) {
                    end = mid - 1;
                } else if (arr[mid] < number) {
                    start = mid + 1;
                } else {
                    checker = true;
                    break;
                }
            }
            if (checker) {
                sb.append(1 + " ");
            } else {
                sb.append(0 + " ");
            }
        }
        System.out.println(sb);
    }
}

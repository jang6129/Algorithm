package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num1920 {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer tk = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        tk = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(tk.nextToken());
            sb.append(function(number) + "\n");
        }

        System.out.println(sb);

    }

    static int function (int number) {
        int left = 0;
        int right = N-1;

        while (right >= left) {
            int mid = (left + right) / 2;
            int value = arr[mid];

            if (value > number) {
                right = mid - 1;
            } else if (value < number){
                left = mid + 1;
            } else {
                return 1;
            }
        }

    return 0;
    }

}

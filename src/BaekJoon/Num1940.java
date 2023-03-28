package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer tk = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        int counter = 0;
        int startingPoint = 0;
        int endPoint = N - 1;

        if (N == 1 && arr[0] == M) System.out.println(1);
        else if (N == 1 && arr[0] != M) System.out.println(0);
        else {
            Arrays.sort(arr);
            while (startingPoint < endPoint) {
                int sum = arr[startingPoint] + arr[endPoint];
                if (sum == M) {
                    counter++;
                    startingPoint++;
                    endPoint--;
                } else if (sum < M) {
                    startingPoint++;
                } else {
                    endPoint--;
                }
            }
            System.out.println(counter);
        }

    }
}

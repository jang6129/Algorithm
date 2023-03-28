package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Num10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer tk = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(tk.nextToken());
            arr[i] = number;
            if (map.containsKey(number)) {
                map.put(number, map.get(number) + 1);
            } else {
                map.put(number, 1);
            }
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
                sb.append(map.get(number) + " ");
            } else {
                sb.append(0 + " ");
            }
        }
        System.out.println(sb);
    }
}

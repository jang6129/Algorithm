package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num2108re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int maxFreq = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
            max = Math.max(max, n);
            min = Math.min(min, n);
            sum += n;
            map.put(n, map.getOrDefault(n, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(n));
        }
        sb.append(Math.round((double)sum / N) + "\n");
        Arrays.sort(arr);
        sb.append(arr[arr.length / 2] + "\n");
        int freqs = Collections.frequency(map.values(), maxFreq);
        if (freqs > 1) {
            List<Integer> mode = new ArrayList<>();
            for (Map.Entry<Integer, Integer> i : map.entrySet()) {
                if (i.getValue() == maxFreq) mode.add(i.getKey());
            }
            Collections.sort(mode);
            sb.append(mode.get(1) + "\n");
        } else {
            for (Map.Entry<Integer, Integer> i : map.entrySet()) {
                if (i.getValue() == maxFreq) {
                    sb.append(i.getKey() + "\n");
                    break;
                }
            }
        }
        sb.append(Math.abs(max - min) + "\n");

        System.out.println(sb);
    }
}
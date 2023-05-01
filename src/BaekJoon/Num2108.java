package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class Num2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(getMean(numbers));
        System.out.println(getMedian(numbers));
        System.out.println(getMode(numbers));
        System.out.println(getRange(numbers));
    }

    public static int getMean(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }

        return (int) Math.round((double) sum / numbers.length);
    }

    public static int getMedian(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length / 2];
    }

    public static int getMode(int[] numbers) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int number : numbers) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        int maxValue = Collections.max(map.values());

        if (Collections.frequency(map.values(), maxValue) == 1) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxValue) {
                    return entry.getKey();
                }
            }
        } else {
            int count = 0;
            int mode = Integer.MIN_VALUE;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxValue) {
                    count++;
                    mode = Math.min(mode, entry.getKey());

                    if (count == 2) {
                        return entry.getKey();
                    }
                }
            }
        }

        return Integer.MIN_VALUE;
    }

    public static int getRange(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length - 1] - numbers[0];
    }
}

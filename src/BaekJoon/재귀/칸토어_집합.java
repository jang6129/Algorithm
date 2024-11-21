package BaekJoon.재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 칸토어_집합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input == null || input.isEmpty()) break;
            int n = Integer.parseInt(input);
            char[] arr = new char[(int) Math.pow(3, n)];
            Arrays.fill(arr, '-');
            cantor(arr, 0, arr.length);
            System.out.println(new String(arr));
        }
    }

    static void cantor(char[] arr, int start, int end) {
        if (end - start < 3) return; // 최소 길이가 3 이상이어야 함
        int third = (end - start) / 3;
        int leftEnd = start + third;
        int middleEnd = start + 2 * third;

        for (int i = leftEnd; i < middleEnd; i++) {
            arr[i] = ' ';
        }

        cantor(arr, start, leftEnd);
        cantor(arr, middleEnd, end);
    }
}
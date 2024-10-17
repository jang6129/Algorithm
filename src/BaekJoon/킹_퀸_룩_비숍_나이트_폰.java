package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 킹_퀸_룩_비숍_나이트_폰 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] inputArr = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            inputArr[i] = Integer.parseInt(input[i]);
        }

        int[] chess = {1, 1, 2, 2, 2, 8};
        int[] answer = new int[6];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inputArr.length; i++) {
            sb.append(chess[i] - inputArr[i] + " ");
        }

        System.out.println(sb);
    }
}

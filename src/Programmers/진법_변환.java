package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 진법_변환 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < N.length(); i++) {
            char c = N.charAt(i);
            int value;
            if (c >= 'A') {
                value = c - 'A' + 10;
            } else {
                value = c - '0';
            }
            sum += value * Math.pow(B, N.length() - 1 - i);
        }

        System.out.println(sum);
    }
}
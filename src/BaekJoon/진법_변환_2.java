package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 진법_변환_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        String N = input[0];
        int B = Integer.parseInt(input[1]);

        int n = Integer.parseInt(N);
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int remainder = n % B;
            if (remainder >= 10) {
                sb.append((char) (remainder - 10 + 'A'));
            } else {
                sb.append(remainder);
            }
            n /= B;
        }

        System.out.println(sb.reverse());


    }
}

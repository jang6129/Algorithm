package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = -1;


        if (N % 5 == 0) sum = N / 5;
        else {
            for (int i = N / 5; i >= 0 / 5; i--) {
                if ((N - (i * 5)) % 3 == 0) {
                    sum++;
                    sum += i;
                    N -= i * 5;
                    sum += N / 3;
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}

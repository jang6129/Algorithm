package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int a = 0; a < N; a++) {
            for (int b = 0; b < N; b++) {
                if (b < a) System.out.print(" ");
                else System.out.print("*");
            }
            System.out.println();
        }
    }
}

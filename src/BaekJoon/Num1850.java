package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        long A = 0;
        long B = 0;

        for (int i = 0; i < 2; i++) {
            A = Long.parseLong(tk.nextToken());
            B = Long.parseLong(tk.nextToken());
        }

        long sumA = 0;
        long sumB = 0;

        for (long i = 0; i < A; i++) {
            sumA += 1 * (Math.pow(10, i));
            if (i < B) sumB += 1 * (Math.pow(10,i));
        }

        System.out.println(gdc(sumA, sumB));

    }

    static long gdc(long a, long b) {
        if (b == 0) return a;
        else {
            return gdc(b, a % b);
        }
    }
}

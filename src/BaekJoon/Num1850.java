package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        long A = Long.parseLong(tk.nextToken());
        long B = Long.parseLong(tk.nextToken());

        long N = gcd(A, B);
        for (int i = 0; i < N; i++) {
            sb.append("1");
        }

        System.out.println(sb);
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

}

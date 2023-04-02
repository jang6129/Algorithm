package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num11382 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        long sum = 0;
        while (tk.hasMoreTokens()) {
            sum += Long.parseLong(tk.nextToken());
        }

        System.out.println(sum);
    }
}

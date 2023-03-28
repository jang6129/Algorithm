package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Num2251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(tk.nextToken());
        int B = Integer.parseInt(tk.nextToken());
        int C = Integer.parseInt(tk.nextToken());

        if (C < A && C < B) {
            System.out.println(C);
            exit(0);
        } else {

        }

    }
}

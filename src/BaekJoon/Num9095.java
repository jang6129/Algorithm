package BaekJoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num9095 {
    static int count = 0;
    static int[] sum = new int[12];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        sum[1] = 1;
        sum[2] = 2;
        sum[3] = 4;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            sb.append(fun(Integer.parseInt(br.readLine())) + "\n");

        }

        System.out.println(sb);
    }

    static int fun(int n) {
        if (n < 0) return 0;
        if (sum[n] != 0) return sum[n];
        else {
            return fun(n - 1) + fun(n - 2) + fun(n - 3);
        }
    }

}

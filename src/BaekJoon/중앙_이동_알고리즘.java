package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 중앙_이동_알고리즘 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int x = 2;

        for (int i = 1; i <= n; i++) {
            x = x * 2 - 1;
        }

        System.out.println(x * x);
    }
}

package BaekJoon.조합론;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 베라의_패션 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                count++;
            }
        }

        System.out.println(count * 2);
    }
}

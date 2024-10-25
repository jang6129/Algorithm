package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 벌집 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 1;
        int range = 1;
        while (range < N) {
            range += 6 * count;
            count++;
        }

        System.out.println(count);
    }
}

package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 세탁소_사장_동혁 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int money = Integer.parseInt(br.readLine());

            int[] coin = {25, 10, 5, 1};
            int[] count = new int[4];

            for (int j = 0; j < 4; j++) {
                count[j] = money / coin[j];
                money %= coin[j];
            }

            for (int j = 0; j < 4; j++) {
                sb.append(count[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

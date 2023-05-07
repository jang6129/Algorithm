package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Num1003 {
    static int[] counter = new int[2];
    static HashMap<Integer, int[]> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int  T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int number = Integer.parseInt(br.readLine());
            fibonacci(number);
            sb.append(counter[0] + " " + counter[1] + "\n");
            map.put(number, new int[] {counter[0], counter[1]});
            counter[0] = 0;
            counter[1] = 1;
        }

        System.out.println(sb);
    }

    static int fibonacci(int n) {
        if (map.containsKey(n)) {
            counter[0] = map.get(n)[0];
            counter[1] = map.get(n)[1];
            return n;
        } else if (n == 0) {
            counter[0]++;
            return 0;
        } else if (n == 1) {
            counter[1]++;
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}

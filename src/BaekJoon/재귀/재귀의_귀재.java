package BaekJoon.재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 재귀의_귀재 {

    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String s = br.readLine();
            count = 0;
            sb.append(recursive(s, 0, s.length() - 1))
                    .append(" ")
                    .append(count)
                    .append("\n");
        }

        System.out.println(sb);
    }

    public static int recursive(String s, int front, int back) {
        count++;
        if (front >= back) return 1;
        if (s.charAt(front) != s.charAt(back)) return 0;
        return recursive(s, front + 1, back - 1);
    }
}

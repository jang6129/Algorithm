package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Num5430_2 {

    static int T;
    static Deque<Integer> q;
    static boolean reversed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String cmd = br.readLine();
            int arrSize = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            q = new ArrayDeque<>();

            for (String num : arr.substring(1, arr.length() - 1).split(",")) {
                if (!num.equals("")) q.add(Integer.parseInt(num));
            }

            reversed = false;
            boolean error = false;

            for (char c : cmd.toCharArray()) {
                if (c == 'R') R();
                else {
                    if (q.size() == 0) {
                        error = true;
                        break;
                    } else {
                        D();
                    }
                }
            }

            if (error) {
                sb.append("error\n");
            } else {
                sb.append("[");
                while (!q.isEmpty()) {
                    sb.append(reversed ? q.pollLast() : q.pollFirst());
                    if (q.size() != 0) sb.append(",");
                }
                sb.append("]\n");
            }
        } // test case ends

        System.out.println(sb);
    }

    static void R() {
        reversed = !reversed;
    }

    static void D() {
        if (reversed) q.pollLast();
        else q.pollFirst();
    }

}

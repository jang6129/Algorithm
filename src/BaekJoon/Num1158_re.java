package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num1158_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        sb.append("<");

        int count = 1;

        while (!q.isEmpty()) {
            if (count == K) {
                sb.append(q.poll());
                count = 1;
                if (!q.isEmpty()) sb.append(", ");
            }
            else {
                q.add(q.poll());
                count++;
            }
        }

        sb.append(">");

        System.out.println(sb);

    }
}

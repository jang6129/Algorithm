package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Num11286 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>((n1, n2) ->
        {
            if (Math.abs(n1) == Math.abs(n2)) return n1 < n2 ? -1 : 1;
            else return Math.abs(n1) - Math.abs(n2);
        });

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0 && q.isEmpty()) sb.append(0 + "\n");
            else if (n == 0 && !q.isEmpty()) sb.append(q.poll() + "\n");
            else q.add(n);
        }

        System.out.println(sb);
    }
}

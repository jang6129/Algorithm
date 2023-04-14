package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Num1325_practice {

    static ArrayList<Integer>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        map = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());

            map[b].add(a);
        }

        int[] counter = new int[N + 1];
        int max = -1;

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
            boolean[] visited = new boolean[N+1];
            counter[i]++;
            visited[i] = true;
            while (!q.isEmpty()) {
                ArrayList<Integer> cur = map[q.poll()];
                if (!cur.isEmpty()) {
                    for (int j : cur) {
                        if (!visited[j]) {
                            q.add(j);
                            counter[i]++;
                            visited[j] = true;
                        }
                    }
                }
            }
            max = Math.max(max, counter[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (counter[i] == max) sb.append(i + " ");
        }

        System.out.println(sb);
    }




}

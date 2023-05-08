package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num1753 {
    static int V;
    static boolean[] visited;
    static int[] distance;
    static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(tk.nextToken());
        int E = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        distance = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[K] = 0;

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            tk = new StringTokenizer(br.readLine());
            int departure = Integer.parseInt(tk.nextToken());
            int destination = Integer.parseInt(tk.nextToken());
            int value = Integer.parseInt(tk.nextToken());
            graph[departure].add(new int[]{destination, value});
        }

        dfs(K);

        for (int i = 1; i <= V; i++) {
            if (i == K) sb.append(0 + "\n");
            else if (distance[i] == Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(distance[i] + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(int n) {
        visited[n] = true;

        for (int[] i : graph[n]) {
            if (!visited[i[0]]) {
                distance[i[0]] = Math.min(distance[i[0]], distance[n] + i[1]);
                dfs(i[0]);
            }
        }
        visited = new boolean[V+1];
    }

}

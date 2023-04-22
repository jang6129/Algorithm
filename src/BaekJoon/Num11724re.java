package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num11724re {

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int nodeN = Integer.parseInt(tk.nextToken());
        int lineN = Integer.parseInt(tk.nextToken());
        // nodeN번 까지 그래프 그려주기
        int[][] graph = new int[nodeN + 1][nodeN + 1];
        // lineN번 만큼 간선 그려주기
        for (int i = 0; i < lineN; i++) {
            tk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());
            // 점끼리 서로 이어주기
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        // 연결 요소 개수 counter, 방문한 node 배열 visited
        int counter = 0;
        visited = new boolean[nodeN + 1];

        for (int i = 1; i <= nodeN; i++) {
            if (!visited[i]) {
                dfs(graph, i);
                counter++;
            }
        }
        System.out.println(counter);
    }

    static void dfs(int[][] graph, int node) {
        visited[node] = true;
        for (int i = 1; i < graph.length; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(graph, i);
            }
        }
    }

}

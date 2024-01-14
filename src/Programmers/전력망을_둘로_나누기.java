package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 전력망을_둘로_나누기 {
    public boolean[][] graph;

    public int solution(int n, int[][] wires) {
        graph = new boolean[n + 1][n + 1];

        for (int[] arr : wires) {
            graph[arr[0]][arr[1]] = true;
            graph[arr[1]][arr[0]] = true;
        }

        int answer = n;
        for (int i = 0; i < wires.length; i++) {
            graph[wires[i][0]][wires[i][1]] = false;
            graph[wires[i][1]][wires[i][0]] = false;
            answer = Math.min(answer, bfs(n, wires[i][0]));
            graph[wires[i][0]][wires[i][1]] = true;
            graph[wires[i][1]][wires[i][0]] = true;
        }

        return answer;
    }

    public int bfs(int n, int start) {
        boolean[] visited = new boolean[n + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int count = 1;
        visited[start] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= n; i++) {
                if (graph[cur][i] && !visited[i]) {
                    q.add(i);
                    count++;
                    visited[i] = true;
                }
            }
        }

        return (int)Math.abs(count-(n-count));
    }
}

package Programmers;

public class 가장_먼_노드 {
    public int solution(int n, int[][] edge) {
        int[][] edges = new int[n+1][n+1];

        // 최단경로 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    edges[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        // 노드 연결
        for (int[] number : edge) {
            edges[number[0]][number[1]] = 1;
            edges[number[1]][number[0]] = 1;
        }
        // 플로이드-워셜
        for (int v = 1; v <= n; v++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if (edges[s][v] != Integer.MAX_VALUE && edges[v][e] != Integer.MAX_VALUE)
                        edges[s][e] = Math.min(edges[s][e], edges[s][v] + edges[v][e]);
                }
            }
        }

        // 최대거리 측정
        int max = 0;
        for (int i = 2; i <= n; i++) {
            if (edges[1][i] != Integer.MAX_VALUE) max = Math.max(max, edges[1][i]);
        }

        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (edges[1][i] == max) answer++;
        }

        return answer;
    }
}

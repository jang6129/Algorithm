package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num1707_ex {
    static int V, E; // 정점의 개수와 간선의 개수
    static ArrayList<Integer>[] graph; // 그래프
    static int[] colors; // 정점의 색 (0: 미방문, 1: 그룹1, 2: 그룹2)
    static boolean isBipartite; // 이분 그래프 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            // 간선 정보 입력
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }

            colors = new int[V + 1];
            Arrays.fill(colors, 0); // 색 초기화
            isBipartite = true;

            // 모든 정점에 대해 DFS 탐색
            for (int i = 1; i <= V; i++) {
                if (colors[i] == 0) { // 아직 방문하지 않은 정점일 경우
                    dfs(i, 1); // 그룹1로 시작
                }
            }

            if (isBipartite) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    // DFS 탐색을 이용하여 이분 그래프 여부 판단
    static void dfs(int v, int color) {
        colors[v] = color; // 현재 정점에 색 지정

        // 인접한 정점에 대해 DFS 탐색
        for (int next : graph[v]) {
            if (colors[next] == color) { // 인접한 정점이 같은 그룹에 속할 경우 (이분 그래프가 아님)
                isBipartite = false;
                return;
            }

            if (colors[next] == 0) { // 아직 방문하지 않은 정점일 경우
                dfs(next, 3 - color); // 다른 그룹의 색으로 탐색 (그룹1: 1, 그룹2: 2 -> 3 - 1 = 2, 3 - 2 = 1)
            }
        }
    }
}

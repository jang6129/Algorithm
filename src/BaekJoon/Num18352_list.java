package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num18352_list {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수
        int K = Integer.parseInt(st.nextToken()); // 거리 정보
        int X = Integer.parseInt(st.nextToken()); // 출발 도시 번호

        ArrayList<Integer>[] graph = new ArrayList[N + 1]; // 인접 리스트로 그래프 구현
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
        }

        boolean[] visited = new boolean[N + 1]; // 방문 체크 배열
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        q.offer(X);
        visited[X] = true;
        int depth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            depth++; // 탐색 깊이 증가
            if (depth > K) break; // 거리 제한을 초과하면 중지

            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                for (int next : graph[cur]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                        if (depth == K) ans.add(next); // K 거리에 있는 도시를 저장
                    }
                }
            }
        }

        if (ans.isEmpty()) System.out.println("-1"); // 찾는 도시가 없는 경우
        else {
            ans.sort(null); // 오름차순으로 정렬
            for (int city : ans) {
                sb.append(city + "\n");
            }
            System.out.println(sb);
        }
    }
}

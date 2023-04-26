package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num11725 {
    static int N;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] mother;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 노드 개수 입력
        N = Integer.parseInt(br.readLine());
        // 노드 개수만큼 1부터 세기
        tree = new ArrayList[N+1];
        // visited 배열 초기화
        visited = new boolean[N+1];
        // 부모 노드 배열 초기화
        mother = new int[N+1];
        // 노드별 리스트 초기화
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        // 엣지 입력
        for (int i = 1; i < N; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        DFS(1);

        for (int i = 2; i <= N; i++) {
            sb.append(mother[i] + "\n");
        }

        System.out.println(sb);
    }

    static void DFS(int n) {
        visited[n] = true;
        for (int next : tree[n]) {
            if (!visited[next]) {
                mother[next] = n;
                DFS(next);
            }
        }
    }

}

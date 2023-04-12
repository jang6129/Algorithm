package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num1325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 노드 (컴퓨터) 수
        int N = Integer.parseInt(tk.nextToken());
        // 노드 수 크기 + 1 크기의 ArrayList 배열 생성
        ArrayList<Integer>[] map = new ArrayList[N + 1];
        // ArrayList 초기화
        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        // 입력 줄 수
        int M = Integer.parseInt(tk.nextToken());
        // 입력 줄 수만큼 입력 받기
        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());
            // 노드 (컴퓨터) 이어주기
            map[b].add(a);
        }

        // 해킹할 수 있는 컴퓨터의 최대 수를 나타내는 max 변수 생성
        int max = -1;
        // 컴퓨터 번호마다 연결된 컴퓨터 수를 저장하는 배열 생성
        int[] count = new int[N+1];
        Queue<Integer> q = new LinkedList<>();
        // 노드 수만큼 반복하며 각 노드에 연결된 컴퓨터 수 탐색
        for (int i = 1; i <= N; i++) {
            // 노드 수만큼 visited 배열 생성
            boolean[] visited = new boolean[N+1];
            // 큐에 시작 노드(i) 입력
            q.add(i);
            // 시작 노드 방문처리
            visited[i] = true;
            // 시작 노드 컴퓨터 수 추가
            count[i]++;
            // 큐가 빌 때까지 BFS
            while (!q.isEmpty()) {
                ArrayList<Integer> cur = map[q.poll()];
                // ArrayList 크기만큼 반복
                for (int j : cur) {
                    if (!visited[j]) {
                        q.add(j);
                        visited[j] = true;
                        count[i] = count[i] + 1;
                    }
                }
            }
            // count된 컴퓨터 수가 max보다 크면 max 갱신
            max = Math.max(max, count[i]);
        }

        // 노드별로 카운트가 max와 같으면 sb에 추가
        for (int i = 1; i <= N; i++) {
            if (count[i] == max) sb.append(i + " ");
        }

        System.out.println(sb);
    }
}

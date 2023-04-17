package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        // 인접 리스트 생성
        ArrayList<Integer>[] map = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        // 진입 차수 배열 생성
        int[] sort = new int[N+1];
        // 입력 받아주기
        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());
            // a가 b의 앞에 온다
            map[a].add(b);
            // b 앞에 오는 학생이 추가된다.
            sort[b]++;
        }

        // Queue 생성
        Queue<Integer> q = new LinkedList<>();
        // Queue에 앞에 오는 학생(sort)이 0인 node를 모두 넣어준다.
        for (int i = 1; i <= N; i++) {
            if (sort[i] == 0) {
                q.add(i);
            }
        }
        // q가 빌 때까지 반복
        while (!q.isEmpty()) {
            // sort[node] = 0인 node를 poll 해준다.
            int cur = q.poll();
            // node가 가리키는 node 리스트 추출
            ArrayList<Integer> list = map[cur];
            // sort[node] = 0인 node 앞줄에 추가
            sb.append(cur + " ");
            // node가 가리키는 node 탐색
            for (int i : list) {
                // 앞 node를 포함하고 있는 node들에서 각각 1씩 빼주면서
                // 먼저 sort[node] = 0이 된 node 넣어주기 (반복문 안에서의 순서는 상관없다)
                sort[i]--;
                if (sort[i] == 0) {
                    q.add(i);
                }
            }
        }

        System.out.println(sb);
    }
}

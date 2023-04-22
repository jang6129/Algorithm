package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1. 건물 수 N 입력, N번까지 정답 배열 생성
        int N = Integer.parseInt(br.readLine());
        // 2. 1 ~ N번까지 건물마다 Queue 생성
        Queue<Integer>[] building = new LinkedList[N + 1];
        // 3. Queue 할당
        for (int i = 0; i <= N; i++) {
            building[i] = new LinkedList<>();
        }
        // 4. 짓는데 걸리는 시간을 담는 timeNeeded, 앞건물 수를 담는 counter 생성
        int[] timeNeeded = new int[N + 1];
        // 5. 걸리는 시간, 앞건물 입력 받기
        for (int i = 1; i <= N; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            // 6. 첫 번째 수는 i번 건물을 짓는데 걸리는 시간
            timeNeeded[i] = Integer.parseInt(tk.nextToken());
            // 7. 그 뒤로는 -1 전까지 앞건물 번호
            while (tk.hasMoreTokens()) {
                int token = Integer.parseInt(tk.nextToken());
                // 8. token이 -1이 아니면 i번 건물의 앞건물로 입력
                if (token != -1) {
                    building[i].add(token);
                }
            }
        }

    }
}

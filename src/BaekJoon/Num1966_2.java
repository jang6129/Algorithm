package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num1966_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스만큼 반복
        for (int a = 0; a < T; a++) {
            // 문서의 개수 N, 해당 문서의 순서 M
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(tk.nextToken());
            int M = Integer.parseInt(tk.nextToken());
            // 각 문서의 중요도 입력
            tk = new StringTokenizer(br.readLine());
            LinkedList<int[]> queue = new LinkedList<>();
            for (int b = 0; b < N; b++) {
                queue.add(new int[]{Integer.parseInt(tk.nextToken()), b});
            }
            int count = 0;
            // 중요도 체크
            while (!queue.isEmpty()) {
                int[] number = queue.poll();
                int flag = 0;
                for (int c = 0; c < queue.size(); c++) {
                    if (queue.get(c)[0] > number[0]) {
                        queue.add(number);
                        for (int d = 0; d < c; d++) {
                            queue.add(queue.poll());
                        }
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    count++;
                    if (number[1] == M) {
                        sb.append(count + "\n");
                        break;
                    }
                }
            }

        }

        System.out.println(sb);

    }
}

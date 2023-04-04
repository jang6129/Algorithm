package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class Num17298 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(-1);
            exit(0);
        } else {
            int[] arr = new int[N];
            int[] answer = new int[N];

            StringTokenizer tk = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(tk.nextToken());
            }

            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < N; i++) {
                if (!stack.isEmpty()) {
                    while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                        answer[stack.pop()] = arr[i];
                    }
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                answer[stack.pop()] = -1;
            }
            for (int i = 0; i < N; i++) {
                sb.append(answer[i] + " ");
            }
            System.out.println(sb);
        }

    }
}


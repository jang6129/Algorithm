package BaekJoon.스택_큐_덱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class queuestack {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] direction = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] num = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int M = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (direction[i] == 0) queue.add(num[i]);
        }
        for (int i = 0; i < M; i++) {
            int n = arr[i];
            queue.addFirst(n);
            sb.append(queue.pollLast()).append(" ");
        }


        System.out.println(sb);
    }
}

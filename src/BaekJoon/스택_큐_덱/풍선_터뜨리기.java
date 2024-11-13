package BaekJoon.스택_큐_덱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class 풍선_터뜨리기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(new int[]{i, arr[i - 1]});
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (!list.isEmpty()) {
            int[] cur = list.remove(idx);
            sb.append(cur[0]).append(" ");
            if (list.isEmpty()) break;
            if (cur[1] > 0) {
                idx = (idx + cur[1] - 1) % list.size();
            } else {
                idx = (idx + cur[1]) % list.size();
                if (idx < 0) idx += list.size();
            }
        }

        System.out.println(sb.toString().trim());
    }
}
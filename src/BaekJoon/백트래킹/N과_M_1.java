package BaekJoon.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과_M_1 {

    static StringBuilder sb = new StringBuilder();
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        boolean[] visited = new boolean[n];
        recur(arr, visited, 0, 0);

        System.out.println(sb);
    }

    // start 매개변수를 추가하여 중복 방지
    public static void recur(int[] arr, boolean[] visited, int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    sb.append(arr[i]).append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        // start부터 시작하여 중복을 피하고 이후 숫자들만 선택
        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                recur(arr, visited, depth + 1, i + 1);  // 다음 재귀 호출에서는 i + 1부터 시작
                visited[i] = false;
            }
        }
    }
}

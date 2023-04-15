package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());
        int[] arr = new int[N];

        tk = new StringTokenizer(br.readLine());
        // arr 채워주기
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        int min = Integer.MAX_VALUE; // 집합 최소 크기 저장
        int counter = 0;

        // 시작, 끝 포인터 설정
        int left = -1;
        int right = -1;

        while (right < N) {
            if (counter < K) {
                right++;
                if (right >= N) break;
                if (arr[right] == 1) counter++;
            } else {
                min = Math.min(min, right - left);
                left++;
                if (arr[left] == 1) counter--;
            }
        }

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
}

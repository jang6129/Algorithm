package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num7568 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] target = new int[N][2];
        int[] answer = new int[N];
        Arrays.fill(answer, 1);

        for (int i = 0; i < N; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            target[i][0] = Integer.parseInt(tk.nextToken());
            target[i][1] = Integer.parseInt(tk.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j != i) {
                    if (target[i][0] < target[j][0] && target[i][1] < target[j][1]) {
                        answer[i]++;
                    }
                }
            }
        }

        for (int i : answer) {
            sb.append(i);
            sb.append(" ");
        }

        System.out.println(sb);
    }
}

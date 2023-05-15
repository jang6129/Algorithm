package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num14501 {
    static int[] day;
    static int[] pay;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        day = new int[N+1];
        pay = new int[N+1];
        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(tk.nextToken());
            pay[i] = Integer.parseInt(tk.nextToken());
        }

//        for ()

    }

    static void recur(int index, int sum) {
        if (day[index] + index - 1 > day.length) {
            max = Integer.max(max, sum);
            return;
        }
        for (int i = index; i <= index + day[index] - 1; i++) {
            visited[i] = true;
        }
    }

}

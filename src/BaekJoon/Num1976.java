package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num1976 {
    static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // map에 (map[index] = index) 값 넣어주기
        map = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            map[i] = i;
        }
        // N번까지 map 그려주기
        for (int i = 1; i <= N; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(tk.nextToken()) == 1) union(i,j);
            }
        }

        // 여행 가능 여부 체크
        tk = new StringTokenizer(br.readLine());
        int startingNode = Integer.parseInt(tk.nextToken());

        while (tk.hasMoreTokens()) {
            if (find(startingNode) != find(Integer.parseInt(tk.nextToken()))) {
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }

    static int find(int n) {
        if (map[n] == n) return n;
        else return map[n] = find(map[n]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) map[b] = a;
    }
}

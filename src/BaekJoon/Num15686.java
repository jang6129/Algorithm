package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num15686 {
    static int N, M;
    static int answer = Integer.MAX_VALUE;
    static int[][] map;
    static ArrayList<int[]> house = new ArrayList<>();
    static ArrayList<int[]> store = new ArrayList<>();
    static ArrayList<int[]> selectedStore = new ArrayList<>();
    static int mCounter = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tk.nextToken());
                if (map[i][j] == 1) house.add(new int[] {i, j});
                else if (map[i][j] == 2) store.add(new int[] {i, j});
            }
        }

        selector(0);

        System.out.println(answer);
    }

    static void selector(int index) {
        if (index >= store.size()) return;
        mCounter++;
        selectedStore.add(store.get(index));
        if (mCounter == M) {
            int sum = 0;
            for (int[] a : house) {
                int tem = Integer.MAX_VALUE;
                for (int[] b : selectedStore) {
                    tem = Math.min(tem, Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]));
                }
                sum += tem;
            }
            answer = Math.min(answer, sum);

            mCounter = 0;
            selectedStore = new ArrayList<>();
        } else {
            for (int i = 0; i < store.size(); i++) selector(index + i);
        }
    }

}

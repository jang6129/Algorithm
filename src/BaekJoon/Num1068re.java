package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num1068re {
    static int N, D, root;
    static int count = 0;
    static ArrayList<Integer>[] list;
    static int[] counter;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        counter = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer tk = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int token = Integer.parseInt(tk.nextToken());
            if (token != -1) {
                list[token].add(i);
            } else {
                root = i;
            }
        }

        D = Integer.parseInt(br.readLine());

        if (D == root) System.out.println(0);
        else {
            DFS(root);
            System.out.println(count);
        }
    }

    static void DFS(int n) {
        if (n == D) return;
        if (list[n].isEmpty() || (list[n].size() == 1 && list[n].contains(D))) {
            count++;
            return;
        }
        for (int next : list[n]) {
            DFS(next);
        }
    }

}

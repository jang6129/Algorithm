package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num1068 {
    static int count = 0;
    static int N, del;
    static ArrayList<Integer>[] tree;
    static int[] mother;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        mother = new int[N];
        visited = new boolean[N];
        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer tk = new StringTokenizer(br.readLine());
        int root = 0;

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(tk.nextToken());
            mother[i] = n;
            if (n != -1) {
                tree[i].add(n);
                tree[n].add(i);
            } else root = i;
        }

        del = Integer.parseInt(br.readLine());
        if (del == root) System.out.println(0);
        else {
            DFS(root);
            System.out.println(count);
        }
    }

    static void DFS(int n) {
        visited[n] = true;
        int child = 0;
        for (int i : tree[n]) {
            if (!visited[i] && i != del) {
                child++;
                DFS(i);
            }
        }
        if (child == 0) count++;
    }

}

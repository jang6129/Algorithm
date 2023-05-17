package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num1967 {

    static class Edge {
        int child, length;

        Edge(int child, int length) {
            this.child = child;
            this.length = length;
        }
    }

    static ArrayList<Edge>[] tree;
    static boolean[] visited;
    static int n, target;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int mother = Integer.parseInt(tk.nextToken());
            int child = Integer.parseInt(tk.nextToken());
            int length = Integer.parseInt(tk.nextToken());
            tree[mother].add(new Edge(child, length));
            tree[child].add(new Edge(mother, length));
        }

        dfs(1, 0);
        dfs(target, 0);

        System.out.println(max);
    } // main() ends

    static void dfs(int node, int totalLength) {
        if (visited[node]) return;
        visited[node] = true;
        if (totalLength > max) {
            target = node;
            max = totalLength;
        }

        for (Edge e : tree[node]) {
            int curNode = e.child;
            if (visited[curNode]) continue;
            dfs(curNode, totalLength + e.length);
        }
        visited[node] = false;
    } // dfs() ends

}

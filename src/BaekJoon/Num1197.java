package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Num1197 {

    static class Edge {
        int start, end, weight;

        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static int V, E;
    static int sum = 0;
    static ArrayList<Edge> list = new ArrayList<>();
    static int[] unionFind;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        V = Integer.parseInt(tk.nextToken());
        E = Integer.parseInt(tk.nextToken());

        unionFind = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            unionFind[i] = i;
        }

        for (int i = 1; i <= E; i++) {
            tk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(tk.nextToken());
            int end = Integer.parseInt(tk.nextToken());
            int weight = Integer.parseInt(tk.nextToken());
            list.add(new Edge(start, end, weight));
        }

        Collections.sort(list, Comparator.comparingInt(e -> e.weight));

        for (Edge e : list) {
            union(e.start, e.end, e.weight);
        }

        System.out.println(sum);
    }

    static int find(int vertex) {
        if (unionFind[vertex] == vertex) return vertex;
        return unionFind[vertex] = find(unionFind[vertex]);
    }

    static void union(int a, int b, int weight) {
        int A = find(a);
        int B = find(b);
        if (A != B) {
            unionFind[B] = unionFind[A];
            sum += weight;
        }
    }


}

package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num1854_2 {

    static int nodeN, edgeN, N;
    static List<Edge>[] node;
    static PriorityQueue<Integer>[] total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer tk = new StringTokenizer(br.readLine());
        nodeN = Integer.parseInt(tk.nextToken());
        edgeN = Integer.parseInt(tk.nextToken());
        N = Integer.parseInt(tk.nextToken());

        node = new List[nodeN + 1];

        for (int i = 1; i <= nodeN; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 1; i <= edgeN; i++) {
            tk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(tk.nextToken());
            int end = Integer.parseInt(tk.nextToken());
            int length = Integer.parseInt(tk.nextToken());
            node[start].add(new Edge(end, length));
        }

        total = new PriorityQueue[nodeN + 1];

        for (int i = 1; i <= nodeN; i++) {
            total[i] = new PriorityQueue<>(Collections.reverseOrder());
        }

        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(1, 0));
        total[1].add(0);

        while (!q.isEmpty()) {
            Edge curEdge = q.poll();
            int curNode = curEdge.node;

            for (Edge e : node[curNode]) {
                int sum = curEdge.length + e.length;
                if (total[e.node].size() < N || total[e.node].peek() > sum) {
                    if (total[e.node].size() >= N) total[e.node].poll();
                    total[e.node].add(sum);
                    q.add(new Edge(e.node, sum));
                }
            }

        }

        for (int i = 1; i <= nodeN; i++) {
            if (total[i].size() >= N) {
                sb.append(total[i].poll() + "\n");
            } else {
                sb.append(-1 + "\n");
            }
        }

        System.out.println(sb);
    }

    static class Edge implements Comparable<Edge> {
        int node, length;

        Edge(int node, int length) {
            this.node = node;
            this.length = length;
        }

        @Override
        public int compareTo(Edge o) {
            return this.length - o.length;
        }
    }


}

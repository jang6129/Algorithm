package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num11657ex {

    static int N, M;
    static long distance[];
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        edges = new Edge[M + 1];
        distance = new long[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(tk.nextToken());
            int end = Integer.parseInt(tk.nextToken());
            int time = Integer.parseInt(tk.nextToken());
            edges[i] = new Edge(start, end, time);
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                if (distance[edge.start] != Integer.MAX_VALUE &&
                        distance[edge.end] > distance[edge.start] + edge.time) {
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }

        boolean mCycle = false;

        for (int i = 0; i < M; i++) {
            Edge edge = edges[i];
            if (distance[edge.start] != Integer.MAX_VALUE &&
                    distance[edge.end] > distance[edge.start] + edge.time) {
                mCycle = true;
            }
        }

        if (!mCycle) {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(distance[i] + "\n");
                }
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }

    }

    static class Edge {
        int start, end, time;

        Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}

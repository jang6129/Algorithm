package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num11657 {

    static class Edge {
        int end, length;

        Edge(int end, int length) {
            this.end = end;
            this.length = length;
        }
    }

    static int nodeN, edgeN;
    static int[] totalLength;
    static ArrayList<Edge>[] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer tk = new StringTokenizer(br.readLine());

        nodeN = Integer.parseInt(tk.nextToken());
        edgeN = Integer.parseInt(tk.nextToken());

        totalLength = new int[nodeN + 1];
        Arrays.fill(totalLength, Integer.MAX_VALUE);
        totalLength[1] = 0;
        node = new ArrayList[nodeN + 1];
        for (int i = 1; i <= nodeN; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeN; i++) {
            tk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(tk.nextToken());
            int end = Integer.parseInt(tk.nextToken());
            int length = Integer.parseInt(tk.nextToken());
            node[start].add(new Edge(end, length));
        }

        BF();
        int[] answer = new int[nodeN + 1];
        for (int i = 1; i <= nodeN; i++) {
            answer[i] = totalLength[i];
        }
        BF();
        boolean flag = false;
        for (int i = 1; i <= nodeN; i++) {
            if (answer[i] != totalLength[i]) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println(-1);
        } else {
            for (int i = 1; i <= nodeN; i++) {
                if (i == 1) continue;
                if (totalLength[i] == Integer.MAX_VALUE) sb.append(-1 + "\n");
                else sb.append(totalLength[i] + "\n");
            }
            System.out.println(sb);
        }
    }

    static void BF() {
        for (int i = 1; i <= nodeN; i++) {
            for (int j = 1; j <= nodeN; j++) {
                for (Edge e : node[j]) {
                    if (totalLength[j] != Integer.MAX_VALUE && totalLength[e.end] > totalLength[j] + e.length) {
                        totalLength[e.end] = totalLength[j] + e.length;
                    }
                }
            }
        }
    }


}

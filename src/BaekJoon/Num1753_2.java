package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num1753_2 {

    static int nodeN, edgeN, startingNode;
    static ArrayList<Road>[] node;
    static boolean[] visited;
    static int[] total;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        nodeN = Integer.parseInt(tk.nextToken());
        edgeN = Integer.parseInt(tk.nextToken());
        startingNode = Integer.parseInt(br.readLine());

        // nodeN번까지 visited, total 배열 생성
        visited = new boolean[nodeN + 1];
        total = new int[nodeN + 1];

        // node 리스트 초기화
        node = new ArrayList[nodeN + 1];
        for (int i = 1; i <= nodeN; i++) {
            node[i] = new ArrayList<>();
        }
        // node 이어주기
        for (int i = 1; i <= edgeN; i++) {
            tk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());
            int length = Integer.parseInt(tk.nextToken());

            node[a].add(new Road(b, length));
        }
        // total 채워주기
        for (int i = 1; i <= nodeN; i++) {
            total[i] = Integer.MAX_VALUE;
        }
        total[startingNode] = 0;

        PriorityQueue<Road> q = new PriorityQueue<>((t1, t2) -> t1.length - t2.length);

        q.add(new Road(startingNode, 0));

        while (!q.isEmpty()) {
            Road curR = q.poll();

            if (visited[curR.destination]) continue;
            visited[curR.destination] = true;

            for (Road r : node[curR.destination]) {
                if (total[r.destination] > total[curR.destination] + r.length) {
                    total[r.destination] = total[curR.destination] + r.length;
                    q.add(new Road(r.destination, total[r.destination]));
                }
            }
        }

        for (int i = 1; i <= nodeN; i++) {
            if (!visited[i]) sb.append("INF\n");
            else sb.append(total[i] + "\n");
        }

        System.out.println(sb);
    }

    static class Road {
        int destination;
        int length;

        Road(int a, int b) {
            this.destination = a;
            this.length = b;
        }
    }

}


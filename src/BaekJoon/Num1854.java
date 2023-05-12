package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Num1854 {
    static int nodeN, lineN, N;
    static List<Line>[] node;
    static PriorityQueue<Integer>[] total;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        nodeN = Integer.parseInt(tk.nextToken());
        lineN = Integer.parseInt(tk.nextToken());
        N = Integer.parseInt(tk.nextToken());

        // node 리스트 생성
        node = new ArrayList[nodeN+1];
        for (int i = 1; i <= nodeN; i++) {
            node[i] = new ArrayList<>();
        }
        // 소요시간 리스트 생성
        total = new PriorityQueue[nodeN+1];
        for (int i = 1; i <= nodeN; i++) {
            total[i] = new PriorityQueue<>();
        }
        // 노드 입력
        for (int i = 0; i < lineN; i++) {
            tk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(tk.nextToken());
            int end = Integer.parseInt(tk.nextToken());
            int length = Integer.parseInt(tk.nextToken());
            node[start].add(new Line(end, length));
        }
        // 다익스트라
        PriorityQueue<Line> q = new PriorityQueue<>((l1, l2) -> {
            return l1.length - l2.length;
        });
        q.add(new Line(1, 0));
        total[1].add(0);

        while(!q.isEmpty()) {
            Line cur = q.poll();
            int curNode = cur.index;

            if (total[curNode].size() >= N) continue;

            for (Line l : node[curNode]) {
                int sum = l.length + cur.length;
                total[l.index].add(sum);
                q.add(new Line(l.index, sum));
            }
        }

        for (int i = 1; i <= nodeN; i++) {
            int answer = -1;
            int counter = N;
            if (total[i].size() >= N) {
                while (counter-- > 0) {
                    answer = total[i].poll();
                }
            }
            sb.append(answer + "\n");
        }

        System.out.println(sb);
    }


    static class Line {
        int index, length;

        Line(int a, int b) {
            index = a;
            length = b;
        }
    }
}

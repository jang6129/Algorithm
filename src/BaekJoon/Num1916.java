package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Num1916 {

    static int N, M, start, end;
    static ArrayList<Line>[] node;
    static int[] totalPrice;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 노드 수 N, 라인 수 M
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        // node 연결 리스트, 최저비용 배열, 방문 배열
        node = new ArrayList[N+1];
        totalPrice = new int[N+1];
        visited = new boolean[N+1];
        // 연결 리스트 초기화
        for (int i = 1; i <= N; i++) {
            node[i] = new ArrayList<>();
        }
        // 비용배열 큰 수로 채워주기
        Arrays.fill(totalPrice, Integer.MAX_VALUE);
        // 입력 받기
        for (int i = 0; i < M; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());
            int c = Integer.parseInt(tk.nextToken());
            node[a].add(new Line(b,c));
        }

        StringTokenizer tk = new StringTokenizer(br.readLine());
        start = Integer.parseInt(tk.nextToken());
        end = Integer.parseInt(tk.nextToken());

        totalPrice[start] = 0;

        PriorityQueue<Line> q = new PriorityQueue<>((l1, l2) -> {
           return l1.price - l2.price;
        });

        q.add(new Line(start, 0));

        while (!q.isEmpty()) {
            Line cur = q.poll();

            if (visited[cur.destination]) continue;
            visited[cur.destination] = true;

            for (Line l : node[cur.destination]) {
                if (totalPrice[l.destination] > l.price + totalPrice[cur.destination]) {
                    totalPrice[l.destination] = l.price + totalPrice[cur.destination];
                    q.add(new Line(l.destination, l.price + totalPrice[cur.destination]));
                }
            }
        }

        System.out.println(totalPrice[end]);

    }

    static class Line {
        int destination, price;
        Line(int a, int b) {
            destination = a;
            price = b;
        }
     }

}

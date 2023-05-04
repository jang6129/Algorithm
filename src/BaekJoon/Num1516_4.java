package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num1516_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] time = new int[N + 1];
        int[] result = new int[N + 1];
        int[] indegree = new int[N + 1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int prerequisite = Integer.parseInt(st.nextToken());
                if (prerequisite == -1) break;
                graph.get(prerequisite).add(i);
                indegree[i]++;
            }
        }

        topologicalSort(N, time, result, indegree, graph);

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        }
    }

    private static void topologicalSort(int N, int[] time, int[] result, int[] indegree, ArrayList<ArrayList<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                result[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (Integer next : graph.get(current)) {
                result[next] = Math.max(result[next], result[current] + time[next]);
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }

        }

    }

}
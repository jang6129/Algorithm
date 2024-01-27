package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 도넛과_막대_그래프 {

    static List<List<Integer>> nodes = new ArrayList<>();

    public int[] solution(int[][] edges) {

        Map<Integer, Integer> pointed = new HashMap<>();
        int createdNode = 0;

        for (int i = 0; i < edges.length; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int destination = edge[1];
            nodes.get(start).add(destination);

            if (pointed.containsKey(start)) {
                pointed.put(start, pointed.get(start) + 1);
            }
            else pointed.put(start, destination);
        }

//        createdNode = pointed.

        int[] answer = {};
        return answer;

    } // solution ends

    public int dfs(int count, int cur, int next, int[][] edges, boolean[] visited) {
        // if ()
        return 0;
    } // dfs ends
}

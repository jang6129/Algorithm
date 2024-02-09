package Programmers;

import java.util.ArrayList;
import java.util.List;

public class 하노이의_탑 {
    List<Integer[]> route = new ArrayList<>();

    public int[][] solution(int n) {
        recur(n, 1, 2, 3);

        int[][] answer = new int[route.size()][2];

        for(int i = 0; i < route.size(); i++) {
            for(int j = 0; j < 2; j++) {
                answer[i][j] = route.get(i)[j];
            }
        }

        return answer;
    }

    public void recur(int n, int from, int via, int to) {
        if (n == 1) {
            route.add(new Integer[] {from, to});
        } else {
            recur(n-1, from, to, via);
            route.add(new Integer[] {from, to});
            recur(n-1, via, from, to);
        }

    }
}

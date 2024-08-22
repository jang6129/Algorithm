package Programmers;

import java.util.Arrays;

public class 요격_시스템 {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

        int edge = 0;
        int count = 0;
        for (int[] target : targets) {
            if (target[0] >= edge) {
                count++;
                edge = Math.max(edge, target[1]);
            }
        }

        return count;
    }
}

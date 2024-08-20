package Programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 도넛과_막대_그래프 {

    public int[] solution(int[][] edges) {
        int max = 0;

        for (int[] edge : edges) {
            max = (edge[0] > max)? edge[0] : max;
            max = (edge[1] > max)? edge[1] : max;
        }

        int[] answer = {0, 0, 0, 0};

        int[][] counter = new int[max + 1][2];

        for (int[] edge : edges) {
            counter[edge[0]][0]++;
            counter[edge[1]][1]++;
        }

        for (int i = 1; i < counter.length; i++) {
            if (counter[i][0] >= 2 && counter[i][1] == 0) {
                answer[0] = i;
            }
            else if (counter[i][0] == 0 && counter[i][1] >= 1) {
                answer[2]++;
            }
            else if (counter[i][0] == 2 && counter[i][1] >= 2) {
                answer[3]++;
            }
        }
        answer[1] = counter[answer[0]][0] - answer[2] - answer[3];

        return answer;

    } // solution ends

}

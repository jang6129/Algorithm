package BaekJoon.정렬;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 소트인사이드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.next();

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N.length(); i++) {
            q.add(N.charAt(i) - '0');
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append(q.poll());
        }

        System.out.println(sb);
    }
}

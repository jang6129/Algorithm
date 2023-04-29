package BaekJoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Num1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        int count = 1;

        while (!queue.isEmpty()) {
            if (count == K) {
                result.add(queue.poll());
                count = 1;
            } else {
                queue.add(queue.poll());
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
            if (i != result.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(">");

        System.out.println(sb.toString());
    }
}

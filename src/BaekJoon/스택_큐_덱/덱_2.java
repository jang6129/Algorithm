package BaekJoon.스택_큐_덱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class 덱_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<String> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");

            if (str[0].equals("1")) deque.addFirst(str[1]);
            else if (str[0].equals("2")) deque.addLast(str[1]);
            else if (str[0].equals("3")) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.pollFirst()).append("\n");
            } else if (str[0].equals("4")) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.pollLast()).append("\n");
            } else if (str[0].equals("5")) {
                sb.append(deque.size()).append("\n");
            } else if (str[0].equals("6")) {
                if (deque.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (str[0].equals("7")) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.peekFirst()).append("\n");
            } else if (str[0].equals("8")) {
                if (deque.isEmpty()) sb.append(-1).append("\n");
                else sb.append(deque.peekLast()).append("\n");
            }
        }

        System.out.println(sb);
    }
}

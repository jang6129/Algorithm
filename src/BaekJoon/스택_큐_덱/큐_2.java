package BaekJoon.스택_큐_덱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 큐_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<String> stack = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            switch (str[0]) {
                case "push": {
                    stack.add(str[1]);
                    break;
                }
                case "pop": {
                    if (stack.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(stack.poll());
                    }
                    break;
                }
                case "size": {
                    sb.append(stack.size());
                    break;
                }
                case "empty": {
                    if (stack.isEmpty()) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    break;
                }
                case "front": {
                    if (stack.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(stack.peek());
                    }
                    break;
                }
                case "back": {
                    if (stack.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(((LinkedList<String>) stack).getLast());
                    }

                }
            }
        }

        System.out.println(sb);
    }
}

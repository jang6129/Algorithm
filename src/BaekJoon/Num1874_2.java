package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import static java.lang.System.exit;

public class Num1874_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int counter = 0;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if (counter < number) {
                while (counter < number) {
                    stack.add(++counter);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if (stack.peek() > number) {
                    System.out.println("NO");
                    exit(0);
                } else {
                    stack.pop();
                    sb.append("-\n");
                }
            }
        }
        System.out.println(sb);
    }
}

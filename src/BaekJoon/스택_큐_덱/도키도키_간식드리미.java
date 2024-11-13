package BaekJoon.스택_큐_덱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class 도키도키_간식드리미 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 1;

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (arr[i] == count) {
                count++;
            } else {
                while (!stack.isEmpty() && stack.peek() == count) {
                    stack.pop();
                    count++;
                }
                if (!stack.isEmpty() && stack.peek() < arr[i]) {
                    System.out.println("Sad");
                    return;
                } else {
                    stack.push(arr[i]);
                }
            }
        }

        System.out.println("Nice");
    }
}
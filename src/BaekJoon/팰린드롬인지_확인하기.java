package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 팰린드롬인지_확인하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> front = new Stack<>();
        Queue<Character> back = new LinkedList<>();

        int length = input.length();
        int mid = length / 2;

        for (int i = 0; i < length; i++) {
            if (i < mid) {
                front.push(input.charAt(i));
            } else if (length % 2 == 0 || i > mid) {
                back.add(input.charAt(i));
            }
        }

        // 4
        // 01, 23
        // 5
        // 01, 34

        while (!front.isEmpty()) {
            if (front.pop() != back.poll()) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }
}
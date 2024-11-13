package BaekJoon.스택_큐_덱;

import java.util.Scanner;
import java.util.Stack;

public class 스택_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // 개행 문자 소비

        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < N; i++) {
            String[] str = sc.nextLine().split(" ");
            if (str.length > 1) {
                stack.push(Integer.parseInt(str[1]));
            } else {
                switch (str[0]) {
                    case "2":
                        if (stack.isEmpty()) {
                            System.out.println(-1);
                        } else {
                            System.out.println(stack.pop());
                        }
                        break;
                    case "3":
                        System.out.println(stack.size());
                        break;
                    case "4":
                        if (stack.isEmpty()) {
                            System.out.println(1);
                        } else {
                            System.out.println(0);
                        }
                        break;
                    case "5":
                        if (stack.isEmpty()) {
                            System.out.println(-1);
                        } else {
                            System.out.println(stack.peek());
                        }
                        break;
                }
            }
        }
    }
}
package BaekJoon;

import java.util.Scanner;

public class 배수와_약수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            if (a % b == 0) sb.append("multiple\n");
            else if (b % a == 0) sb.append("factor\n");
            else sb.append("neither\n");
        }

        System.out.println(sb);
    }
}

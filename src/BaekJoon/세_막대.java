package BaekJoon;

import java.util.Scanner;

public class 세_막대 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int sum = 0;

        int a = sc.nextInt();
        max = Math.max(max, a);
        sum += a;
        int b = sc.nextInt();
        max = Math.max(max, b);
        sum += b;
        int c = sc.nextInt();
        max = Math.max(max, c);
        sum += c;

        if (sum <= max * 2) System.out.println((sum-max) * 2 - 1);
        else System.out.println(sum);
    }
}

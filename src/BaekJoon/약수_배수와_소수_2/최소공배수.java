package BaekJoon.약수_배수와_소수_2;

import java.util.Scanner;

public class 최소공배수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long aa = a;
        long bb = b;

        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }

        System.out.println(aa * bb / a);

    }
}

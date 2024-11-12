package BaekJoon.약수_배수와_소수_2;

import java.util.Scanner;

public class 분수_합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A1 = sc.nextInt();
        int AA1 = A1;
        int B1 = sc.nextInt();
        int BB1 = B1;
        int A2 = sc.nextInt();
        int AA2 = A2;
        int B2 = sc.nextInt();
        int BB2 = B2;

        while (B2 != 0) {
            int r = B1 % B2;
            B1 = B2;
            B2 = r;
        }

        int bottom = BB1 * BB2 / B1;
        int b = bottom;
        int top = AA1 * (bottom / BB1) + AA2 * (bottom / BB2);
        int t = top;

        while (top != 0) {
            int r = bottom % top;
            bottom = top;
            top = r;
        }

        System.out.println(t / bottom + " " + b / bottom);


    }
}

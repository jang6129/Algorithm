package BaekJoon.약수_배수와_소수_2;

import java.util.Scanner;

public class 창문_닫기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = (int) Math.sqrt(N);
        System.out.println(count);
    }
}
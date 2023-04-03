package BaekJoon;

import java.util.Scanner;

public class Num2440 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int a = N; a > 0; a--) {
            for (int b = a; b > 0; b--) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}

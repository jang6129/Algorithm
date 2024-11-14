package BaekJoon.조합론;

import java.util.Scanner;

public class 이항_계수_1 {
    // 팩토리얼을 계산하는 메서드
    static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // N과 K를 입력 받기
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.close();

        // 이항 계수 계산 공식: C(n, k) = n! / (k! * (n - k)!)
        int binomialCoefficient = factorial(n) / (factorial(k) * factorial(n - k));

        // 결과 출력
        System.out.println(binomialCoefficient);
    }
}
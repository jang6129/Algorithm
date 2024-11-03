package BaekJoon;

import java.util.Scanner;

public class 알고리즘_수업_점근적_표기_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int a1 = scanner.nextInt();  // f(n)에서 a1의 계수
        int a0 = scanner.nextInt();  // f(n)에서 상수 항
        int c = scanner.nextInt();   // 상수 c
        int n0 = scanner.nextInt();  // 시작 값 n0

        boolean satisfies = true;

        // n = n0 이상에서 조건 확인
        for (int n = n0; n <= 100; n++) {
            int fn = a1 * n + a0;      // f(n) 계산
            int gn = c * n;            // c * n 계산

            if (fn > gn) {             // f(n) > c * n 이면 조건 만족하지 않음
                satisfies = false;
                break;
            }
        }

        // 조건을 만족하면 1, 아니면 0 출력
        System.out.println(satisfies ? 1 : 0);
    }
}

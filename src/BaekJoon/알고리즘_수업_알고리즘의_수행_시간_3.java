package BaekJoon;

import java.util.Scanner;

public class 알고리즘_수업_알고리즘의_수행_시간_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 입력 크기 n 받기

        long count = 0;  // 합을 저장할 변수
        // 두 개의 중첩된 반복문 사용
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                count++;
            }
        }

        System.out.println(count + "\n2");  // 결과 출력
    }
}

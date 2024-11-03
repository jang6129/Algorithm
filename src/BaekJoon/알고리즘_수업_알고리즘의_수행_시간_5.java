package BaekJoon;

import java.util.Scanner;

public class 알고리즘_수업_알고리즘의_수행_시간_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 입력의 크기 n 받기

        System.out.println((long) n * n * n);  // 수행 횟수 출력
        System.out.println(3);  // 시간 복잡도의 최고차항 차수는 3 (O(n^3))
    }
}

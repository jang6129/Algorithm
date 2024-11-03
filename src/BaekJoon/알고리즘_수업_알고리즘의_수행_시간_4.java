package BaekJoon;

import java.util.Scanner;

public class 알고리즘_수업_알고리즘의_수행_시간_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 입력의 크기 n 받기

        // 수행 횟수는 조합의 수와 같음: n * (n - 1) / 2
        System.out.println((long) n * (n - 1) / 2);
        System.out.println(2);  // 시간 복잡도의 최고차항 차수는 2 (O(n^2))
    }
}

package BaekJoon.조합론;

import java.util.Scanner;

public class 다리_놓기 {
    // 이항 계수를 일일이 계산하는 메서드
    static int binomialCoefficient(int n, int k) {
        int result = 1;
        // k가 n/2보다 크면 대칭성을 이용하여 계산을 단순화
        if (k > n - k) {
            k = n - k;
        }
        // 일일이 곱셈을 통해 이항 계수를 계산
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 테스트 케이스 개수 입력 받기
        int t = scanner.nextInt();

        // 각 테스트 케이스에 대해 계산
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            // 이항 계수 계산을 통해 다리를 지을 수 있는 경우의 수를 계산
            int result = binomialCoefficient(m, n);
            // 결과 출력
            System.out.println(result);
        }
        scanner.close();
    }
}

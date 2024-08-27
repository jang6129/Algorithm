package Programmers;

import java.util.HashSet;
import java.util.Set;

public class N으로_표현 {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }

        // dp 리스트 초기화
        Set<Integer>[] dp = new HashSet[9];
        for (int i = 1; i < 9; i++) {
            dp[i] = new HashSet<>();
            dp[i].add(Integer.parseInt(String.valueOf(N).repeat(i))); // N, NN, NNN 등을 추가
        }

        // DP로 문제 해결
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (int op1 : dp[j]) {
                    for (int op2 : dp[i - j]) {
                        dp[i].add(op1 + op2);
                        dp[i].add(op1 - op2);
                        dp[i].add(op1 * op2);
                        if (op2 != 0) {
                            dp[i].add(op1 / op2);
                        }
                    }
                }
            }
            // 목표 숫자가 dp[i]에 있으면 반환
            if (dp[i].contains(number)) {
                return i;
            }
        }

        // 8번 안에 만들 수 없는 경우 -1 반환
        return -1;
    }
}

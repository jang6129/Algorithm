package Programmers;

import java.util.HashSet;
import java.util.Set;

public class N으로_표현 {
    public int solution(int N, int number) {
//        Set<Integer>[] dp = new HashSet[9];
//        for (int i = 1; i < 9; i++) {
//            dp[i] = new HashSet<>();
        // N, NN 추가하는 깔끔한 방법
//            dp[i].add(Integer.parseInt(String.valueOf(N).repeat(i))); // N, NN, NNN 등을 추가
//        }

        if (N == number) return 1;

        HashSet<Integer>[] set = new HashSet[9];

        for (int i = 1; i < 9; i++) {
            set[i] = new HashSet<>();
        }
        // N, NN, NNN 등을 추가해준다
        set[1].add(N);
        set[2].add(N*10 + N);
        set[3].add(N*100 + N*10 + N);
        set[4].add(N*1000 + N*100 + N*10 + N);
        set[5].add(N*10000 + N*1000 + N*100 + N*10 + N);
        set[6].add(N*100000 + N*1000 + N*100 + N*10 + N);

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                // ex) i = 5일 때
                // j = 1 에서 시작해서 j = 4 까지
                // i - j = 4 에서 시작해서 1 까지
                // 따라서 결과적으로 (o1 - o2), (o2 - o1) 양쪽으로 계산된다.
                for (int o1 : set[j]) {
                    for (int o2 : set[i - j]) {
                        set[i].add(o1 + o2);
                        set[i].add(o1 * o2);
                        set[i].add(o1 - o2);
                        if (o2 != 0) set[i].add (o1 / o2);
                    }
                }
            }
            if (set[i].contains(number)) return i;
        }

        return -1;
    }

}

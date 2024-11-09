package BaekJoon.집합과_맵;

import java.util.HashSet;
import java.util.Scanner;

public class 문자열_집합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(sc.next());
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            if (set.contains(sc.next())) {
                count++;
            }
        }

        System.out.println(count);

    }
}

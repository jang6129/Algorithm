package BaekJoon.집합과_맵;

import java.util.HashSet;
import java.util.Scanner;

public class 대칭_차집합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        int N = sc.nextInt();
        int M = sc.nextInt();

        int count = 0;
        for (int i = 0; i < N + M; i++) {
            int num = sc.nextInt();
            if (set.contains(num)) count++;
            set.add(num);
        }

        System.out.println(set.size() - count);
    }
}

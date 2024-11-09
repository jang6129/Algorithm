package BaekJoon.집합과_맵;

import java.util.HashSet;
import java.util.Scanner;

public class 서로_다른_부분_문자열의_개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                set.add(s.substring(i, j));
            }
        }

        System.out.println(set.size());
    }
}

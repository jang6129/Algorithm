package BaekJoon.집합과_맵;

import java.util.HashMap;
import java.util.Scanner;

public class 나는야_포켓몬_마스터_이다솜 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> pocketmon = new HashMap<>();

        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            String name = sc.next();
            String idx = Integer.toString(i);
            pocketmon.put(idx, name);
            pocketmon.put(name, idx);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(pocketmon.get(sc.next()) + "\n");
        }

        System.out.println(sb);
    }
}

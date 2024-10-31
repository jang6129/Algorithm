package BaekJoon;

import java.util.*;

public class 소인수분해 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        if (n==1) return;

        List<Integer> list = new ArrayList<>();
        while (n > 1) {
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    list.add(i);
                    n /= i;
                    break;
                }
            }
        }

        for (int i : list) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}

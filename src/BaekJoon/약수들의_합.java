package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class 약수들의_합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = sc.nextInt();
            if (n == -1) break;

            sb.append(n + " ");
            ArrayList<Integer> list = new ArrayList<>();
            int sum = 0;
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    sum += i;
                    list.add(i);
                }
            }

            if (sum == n) {
                sb.append("= ");
                sb.append(list.get(0) + " ");
                if (list.size() >= 2) {
                    for (int i = 1; i < list.size(); i++) {
                        sb.append("+ " + list.get(i) + " ");
                    }
                    sb.append("\n");
                }
            }
            else {
                sb.append("is NOT perfect.\n");
            }

        }

        System.out.println(sb);
    }
}

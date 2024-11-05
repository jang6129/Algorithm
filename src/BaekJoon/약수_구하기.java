package BaekJoon;

import java.util.ArrayList;
import java.util.Scanner;

public class 약수_구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        int N = sc.nextInt();
        int K = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                list.add(i);
            }
        }
        if (K > list.size()) {
            System.out.println(0);
            return;
        }
        System.out.println(list.get(K-1));
    }
}

package BaekJoon;

import java.util.Scanner;

public class 영화감독_숀 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int cnt = 0;
        int num = 666;

        while (true) {
            if (String.valueOf(num).contains("666")) {
                cnt++;
            }
            if (cnt == N) {
                break;
            }
            num++;
        }

        System.out.println(num);
    }
}

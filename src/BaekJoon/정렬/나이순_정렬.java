package BaekJoon.정렬;

import java.util.Arrays;
import java.util.Scanner;

public class 나이순_정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[][] arr = new String[N][2];

        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.next();
            arr[i][1] = sc.next();
        }

        Arrays.sort(arr, (o1, o2) -> Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]));

        StringBuilder sb = new StringBuilder();
        for (String[] s : arr) {
            sb.append(s[0]).append(" ").append(s[1]).append("\n");
        }

        System.out.println(sb);
    }
}

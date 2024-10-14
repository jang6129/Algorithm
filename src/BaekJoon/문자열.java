package BaekJoon;

import java.util.Scanner;

public class 문자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < T; i++) {
            String str = sc.nextLine();
            System.out.print(str.charAt(0));
            System.out.println(str.charAt(str.length() - 1));
        }

    }
}

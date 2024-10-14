package BaekJoon;

import java.util.Scanner;

public class 문자와_문자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int i = sc.nextInt() - 1;

        System.out.println(str.charAt(i));

    }
}

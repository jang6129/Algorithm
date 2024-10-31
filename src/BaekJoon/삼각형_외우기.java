package BaekJoon;

import java.util.HashSet;
import java.util.Scanner;

public class 삼각형_외우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            int n = sc.nextInt();
            sum += n;
            set.add(n);
        }

        if (sum != 180) System.out.println("Error");
        else if (set.size() == 1) System.out.println("Equilateral");
        else if (set.size() == 2) System.out.println("Isosceles");
        else System.out.println("Scalene");
    }
}

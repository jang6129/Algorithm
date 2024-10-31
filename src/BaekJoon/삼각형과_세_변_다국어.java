package BaekJoon;

import java.util.HashSet;
import java.util.Scanner;

public class 삼각형과_세_변_다국어 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            HashSet<Integer> set = new HashSet<>();
            int max = 0;
            int sum = 0;
            int a = sc.nextInt();
            max = Math.max(max, a);
            sum += a;
            int b = sc.nextInt();
            max = Math.max(max, b);
            sum += b;
            int c = sc.nextInt();
            max = Math.max(max, c);

            if (a == 0 && b == 0 && c == 0) {
                return;
            }

            sum += c;
            set.add(a);
            set.add(b);
            set.add(c);

            if (sum <= max * 2) {
                System.out.println("Invalid");
            }
            else if (set.size() == 1) {
                System.out.println("Equilateral");
            }
            else if (set.size() == 2) {
                System.out.println("Isosceles");
            }
            else {
                System.out.println("Scalene");
            }

        }

    }
}

package BaekJoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 네_번째_점 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        Set<Integer> x = new HashSet<>();
        Set<Integer> y = new HashSet<>();

        x.add(x1);
        y.add(y1);

        if (x.contains(x2)) x.remove(x2);
        else x.add(x2);

        if (y.contains(y2)) y.remove(y2);
        else y.add(y2);

        if (x.contains(x3)) x.remove(x3);
        else x.add(x3);

        if (y.contains(y3)) y.remove(y3);
        else y.add(y3);

        System.out.println(x.toArray()[0] + " " + y.toArray()[0]);
    }
}

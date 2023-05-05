package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num1193 {

    static int X, count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());

        fun();
    }

    static void fun() {
        while (X != 0) {
            count++;
            int x, y;
            if (count % 2 == 0) {
                x = 1;
                y = count;
                X--;
                if (X == 0) {
                    System.out.println(x + "/" + y);
                    return;
                }
                while (y > 1) {
                    x++;
                    y--;
                    X--;
                    if (X == 0) {
                        System.out.println(x + "/" + y);
                        return;
                    }
                }
            } else {
                x = count;
                y = 1;
                X--;
                if (X == 0) {
                    System.out.println(x + "/" + y);
                    return;
                }
                while (x > 1) {
                    x--;
                    y++;
                    X--;
                    if (X == 0) {
                        System.out.println(x + "/" + y);
                        return;
                    }
                }
            }

        }

    } // fun() ends

}

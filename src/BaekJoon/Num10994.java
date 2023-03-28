package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num10994 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int input = Integer.parseInt(br.readLine());
        int size = 1 + ((input - 1) * 4);
        int count = 0;

        while (count < size) {
            if (count == 0 || count == size - 1) {
                for (int i = 0; i < size; i++) {
                    sb.append("*");
                }
            } else if (count % 2 == 0) {

            }

        }

    }
}

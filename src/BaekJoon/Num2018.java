package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int counter = 1;
        int startingPoint = 1;
        int endPoint = 1;
        int sum = 1;

        while (endPoint != N) {
            if (sum == N) {
                counter++;
                endPoint++;
                sum += endPoint;
            } else if (sum > N) {
                sum -= startingPoint;
                startingPoint++;
            } else {
                endPoint++;
                sum += endPoint;
            }
        }

        System.out.println(counter);

    }
}

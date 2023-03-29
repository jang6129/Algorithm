package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer tk = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(tk.nextToken());
        }

        if (N == 1) {
            System.out.println(1);
        } else {
            Arrays.sort(numbers);

            int count = 0;

            for (int a = 0; a < N; a++) {
                int startingPoint = 0;
                int endPoint = N - 1;
                while (startingPoint < endPoint) {
                    if (startingPoint == a) startingPoint++;
                    else if (endPoint == a) endPoint--;
                    else {
                        int sum = numbers[startingPoint] + numbers[endPoint];
                        if (numbers[a] == sum) {
                            count++;
                            break;
                        } else if (numbers[a] < sum) {
                            endPoint--;
                        } else {
                            startingPoint++;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}

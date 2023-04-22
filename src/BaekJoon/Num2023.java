package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Num2023 {

    static HashSet<Integer> prime = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        // N 자리 숫자까지의 소수를 에라토스테네스의 체로 모두 구해준다
        sifter(N);
        int n = (int) Math.pow(10, N);

        for (int i = n / 10 + 1; i < n; i++) {
            if (prime.contains(i)) {
                boolean flag = true;
                String str = String.valueOf(i);
                StringBuilder bf = new StringBuilder();
                for (int j = 0; j < str.length() - 1; j++) {
                    bf.append(str.charAt(j));
                    if (prime.contains(Integer.parseInt(String.valueOf(bf)))) continue;
                    flag = false;
                    break;
                }
                if (flag) {
                    sb.append(i + "\n");
                }
            }
        }

        System.out.println(sb);
    }

    static void sifter(int N) {
        int n = (int) Math.pow(10, N);
        int[] arr = new int[n];
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (arr[i] == 1) continue;

            for (int j = i + i; j < n; j = j + i) {
                arr[j] = 1;
            }
        }
        for (int i = 2; i < n; i++) {
            if (arr[i] == 0) {
                prime.add(i);
            }
        }
    }

}

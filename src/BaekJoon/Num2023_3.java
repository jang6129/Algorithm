package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Num2023_3 {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        DFS("");

        System.out.println(sb);
    } // main() ends

    static void DFS(String num) {
        if (num.length() == N) {
            sb.append(num + "\n");
            return;
        }
        for (int i = 1; i <= 9; i++) {
            String cur = num + i;
            if (isPrime(Integer.parseInt(cur))) DFS(cur);
        }
    } // DFS() ends

    static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    } // isPrime() ends

} // Class ends

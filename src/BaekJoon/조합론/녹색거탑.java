package BaekJoon.조합론;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 녹색거탑 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println((int) Math.pow(2, n));
    }
}
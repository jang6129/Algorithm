package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 코딩은_체육과목_입니다 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder("long");

        for (int i = 1; i < N /4; i++) {
            answer.append(" long");
        }

        answer.append(" int");

        System.out.println(answer);
    }
}

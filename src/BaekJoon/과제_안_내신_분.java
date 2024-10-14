package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 과제_안_내신_분 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= 30; i++) {
            set.add(i);
        }

        for (int i = 0; i < 28; i++) {
            set.remove(Integer.parseInt(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();
        for (int i : set) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}

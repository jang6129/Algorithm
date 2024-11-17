package BaekJoon.심화_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 붙임성_좋은_총총이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> dance = new HashSet<>();
        dance.add("ChongChong");
        while (n-- > 0) {
            String[] arr = br.readLine().split(" ");
            if (dance.contains(arr[0]) || dance.contains(arr[1])) {
                dance.add(arr[0]);
                dance.add(arr[1]);
            }
        }

        System.out.println(dance.size());
    }
}

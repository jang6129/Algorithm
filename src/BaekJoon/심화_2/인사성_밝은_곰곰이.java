package BaekJoon.심화_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 인사성_밝은_곰곰이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        Set<String> set = new HashSet<>();
        while (n-- > 0) {
            String s = br.readLine();
            if (s.equals("ENTER")) {
                set = new HashSet<>();
            } else {
                if (!set.contains(s)) {
                    count++;
                    set.add(s);
                }
            }

        }

        System.out.println(count);
    }
}

package BaekJoon.심화_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 영단어_암기는_괴로워 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        while (N-- > 0) {
            String s = br.readLine();
            if (s.length() < M) continue;
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> {
            if (!o1.getValue().equals(o2.getValue())) {
                return o2.getValue() - o1.getValue();
            }
            if (o1.getKey().length() != o2.getKey().length()) {
                return o2.getKey().length() - o1.getKey().length();
            }
            return o1.getKey().compareTo(o2.getKey());
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : list) {
            sb.append(entry.getKey()).append("\n");
        }

        System.out.println(sb);
    }
}
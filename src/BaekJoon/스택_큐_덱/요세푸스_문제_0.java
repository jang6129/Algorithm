package BaekJoon.스택_큐_덱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class 요세푸스_문제_0 {
    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= input[0]; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int index = 0;
        while (list.size() > 0) {
            index = (index + input[1] - 1) % list.size();
            sb.append(list.remove(index)).append(", ");
        }

        System.out.println(sb.substring(0, sb.length() - 2) + ">");
    }
}

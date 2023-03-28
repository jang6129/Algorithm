package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Num1966 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine());

        for (int a = 0; a < tests; a++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(tk.nextToken());
            int M = Integer.parseInt(tk.nextToken());
            tk = new StringTokenizer(br.readLine());
            int count = 0;
            int max = 1;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int[] arr = new int[N];
            for (int b = 0; b < N; b++) {
                arr[b] = Integer.parseInt(tk.nextToken());
                if (map.containsKey(arr[b])) map.put(arr[b], map.get(arr[b]) + 1);
                else map.put(arr[b], 1);
                if (arr[b] > max) max = arr[b];
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(arr[0]);
            while(!queue.isEmpty()) {
                int number = queue.poll();
                if (number == max) {
                    map.put(number, map.get(number) - 1);
                    if (map.get(number) == 0) max--;
                    count++;
                }
            }

        }
        System.out.println(sb);
    }

//    static void fun(int ) {
//
//    }

}

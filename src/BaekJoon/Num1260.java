package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Num1260 {

    static StringBuilder sb = new StringBuilder();
    static int[][] dots;
    static int[] checker;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tk = new StringTokenizer(br.readLine());

        int dotN = Integer.parseInt(tk.nextToken());
        int lineN = Integer.parseInt(tk.nextToken());
        int start = Integer.parseInt(tk.nextToken());

        dots = new int[dotN + 1][dotN + 1];

        for (int i = 0; i < lineN; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int input1 = Integer.parseInt(input.nextToken());
            int input2 = Integer.parseInt(input.nextToken());
            dots[input1][input2] = 1;
            dots[input2][input1] = 1;
        }
        checker = new int[dots.length + 1];
        DFS(start);
        sb.append("\n");
        checker = new int[dots.length + 1];
        BFS(start);

        System.out.println(sb.toString());
    }

    static void DFS(int start) {
        checker[start] = 1;
        sb.append(start + " ");

        for (int i = 0; i < dots.length; i++) {
            if (dots[start][i] == 1 && checker[i] != 1) {
                DFS(i);
            }
        }
    }

    static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int pointer;
        int[] checker = new int[dots.length];

        queue.add(start);
        checker[start] = 1;

        while (!queue.isEmpty()) {
            pointer = queue.poll();
            sb.append(pointer + " ");
            for (int i = 1; i < dots.length; i++) {
                if (dots[pointer][i] == 1 && checker[i] != 1) {
                    queue.add(i);
                    checker[i] = 1;
                }
            }
        }

    }

}

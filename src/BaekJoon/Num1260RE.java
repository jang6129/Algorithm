package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num1260RE {

    static int N, M, V;
    static int[][] arr;
    static int[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        V = Integer.parseInt(tk.nextToken());
        arr = new int[N + 1][N + 1];
        visited = new int[N + 1];

        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(tk.nextToken());
            int column = Integer.parseInt(tk.nextToken());
            arr[row][column] = arr[column][row] = 1;
        }


        DFS(V);
        sb.append("\n");
        visited = new int[N+1];
        BFS(V);

        System.out.println(sb);

    }

    static void DFS(int number) {
        Stack<Integer> stack = new Stack<>();
        stack.add(number);
        sb.append(number + " ");
        visited[number] = 1;

        while (!stack.isEmpty()) {
            int target = stack.peek();

            for (int i = 1; i <= N; i++) {
                if (arr[target][i] == 1 && visited[i] != 1) {
                    stack.add(i);
                    sb.append(i + " ");
                    visited[i] = 1;
                    break;
                }
            }
        }
    }

    static void BFS(int number) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(number);
        sb.append(number + " ");
        visited[number] = 1;
        while (!queue.isEmpty()) {
            int target = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (arr[target][i] == 1 && visited[i] != 1) {
                    queue.add(i);
                    sb.append(i + " ");
                    visited[i] = 1;
                }
            }
        }
    }

}
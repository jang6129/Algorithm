package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num1991 {

    static int N;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            int a = tk.nextToken().charAt(0) - 65;
            int b = tk.nextToken().charAt(0) - 65;
            int c = tk.nextToken().charAt(0) - 65;
            if (b != -19) tree[a].add(b);
            else tree[a].add(-1);
            if (c != -19) tree[a].add(c);
            else tree[a].add(-1);
        }

        if (N == 1) {
            System.out.println(new StringBuffer("A" + "\n" + "A" + "\n" + "A"));
        } else {
            front(0);
            sb.append("\n");
            middle(0);
            sb.append("\n");
            rear(0);
            sb.append("\n");

            System.out.println(sb);
        }

    } // main() ends

    static void front(int index) {
        if (index == -1) return;
        sb.append((char) (index + 65));
//        for (int next : tree[index]) {
//            front(next);
//        }
        front(tree[index].get(0));
        front(tree[index].get(1));
    } // front() ends

    static void middle(int index) {
        if (index == -1) return;
        middle(tree[index].get(0));
        sb.append((char) (index + 65));
        middle(tree[index].get(1));
    }

    static void rear(int index) {
        if (index == -1) return;
        rear(tree[index].get(0));
        rear(tree[index].get(1));
        sb.append((char) (index + 65));
    }

}

package BaekJoon;

import java.io.*;
import java.util.*;

public class Num13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tk = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(tk.nextToken());
        int L = Integer.parseInt(tk.nextToken());

        LinkedHashSet<String> q = new LinkedHashSet<>();
        Stack<int[]> stack = new Stack<>();

        for (int a = 0; a < L; a++) {
            String input = br.readLine();
            if (q.contains(input)) q.remove(input);
            q.add(input);
        }

        int count = 0;
        for (String number : q) {
            bw.write(number + "\n");
            count++;
            if (count == K) break;
        }

        bw.flush();
        bw.close();
    }
}

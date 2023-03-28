package BaekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num2805Final {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        long N = Long.parseLong(tk.nextToken());
        long M = Long.parseLong(tk.nextToken());

        tk = new StringTokenizer(br.readLine());

        long[] length = new long[(int)N];

        long max = 0;

        for (int i = 0; i < N; i++) {
            length[i] = Integer.parseInt(tk.nextToken());
            if (length[i] > max) {
                max = length[i];
            }
        }

        long min = 0;
        long counter;
        long pointer;

        while (max > min) {
            pointer = (max + min) / 2;
            counter = 0;
            for (int i = 0; i < N; i++) {
                if (length[i] > pointer) {
                    counter += length[i] - pointer;
                }
            }
            if (counter < M) {
                max = pointer;
            } else {
                min = pointer + 1;
            }
        }
        System.out.println(min - 1);
    }
}

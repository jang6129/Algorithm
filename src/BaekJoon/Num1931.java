package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Num1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(tk.nextToken());
            meetings[i][1] = Integer.parseInt(tk.nextToken());
        }

        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int currentTime = 0;
        int meeting = 0;

        for (int i = 0; i < N; i++) {
            if (meetings[i][0] >= currentTime) {
                meeting++;
                currentTime = meetings[i][1];
            }
        }

        System.out.println(meeting);
    }
}

package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Num11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        Comparator<int[]> c = (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            else {
                return o1[0] - o2[0];
            }
        };

//        Comparator<int[]> d = new Comparator<>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] == o2[0]) return o1[1] - o2[1];
//                else {
//                    return o1[0] - o2[0];
//                }
//            }
//        };

        Arrays.sort(arr, c);

        StringBuilder sb = new StringBuilder();
        for (int[] i : arr) {
            sb.append(i[0] + " " + i[1] + "\n");
        }

        System.out.println(sb);

    }
}

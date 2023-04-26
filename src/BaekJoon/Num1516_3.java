package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num1516_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> building = new ArrayList<>();
        // index 뒤에 오는 빌딩 개수
        int[] counter = new int[N+1];
        // 짓는데 걸리는 총 시간
        int[] time = new int[N+1];
        // index만 지을 때 걸리는 시간
        int[] timeSelf = new int[N+1];

        for (int i = 0; i <= N; i++) {
            building.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer tk = new StringTokenizer(br.readLine());
            timeSelf[i] = Integer.parseInt(tk.nextToken());
            while (tk.hasMoreTokens()) {
                int token = Integer.parseInt(tk.nextToken());
                if (token == -1) break;
                building.get(token).add(i);
                counter[token]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            // i 뒤에 오는 빌딩이 없으면 q에 넣어주고 걸리는 시간을 입력해준다.
            if (counter[i] == 0) {
                q.add(i);
                time[i] = timeSelf[i];
            }
        }

        while(!q.isEmpty()) {
            // curList의 뒤
            int curList = q.poll();
            for (int i : building.get(curList)) {
                time[i] = Math.max(time[i], time[curList]);
            }
        }


    }
}

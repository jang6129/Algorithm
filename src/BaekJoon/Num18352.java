package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Num18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 도시의 개수, 도로의 개수, 거리 정보, 출발 도시의 번호를 입력받음
        int cityN = Integer.parseInt(tk.nextToken());
        int roadN = Integer.parseInt(tk.nextToken());
        int distance = Integer.parseInt(tk.nextToken());
        int startingCity = Integer.parseInt(tk.nextToken());

        // 각 도시에서 갈 수 있는 도시들의 정보를 저장하는 리스트
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();

        for (int i = 0; i <= cityN; i++) {
            map.add(new ArrayList<>());
        }

        // 각 도로의 정보를 입력받아 리스트에 추가
        for (int i = 0; i < roadN; i++) {
            tk = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(tk.nextToken());
            int to = Integer.parseInt(tk.nextToken());
            map.get(from).add(to);
        }

        boolean flag = false;
        Queue<ArrayList<Integer>[]> q = new LinkedList<>();
        boolean[] visited = new boolean[cityN + 1];

        // 거리가 1인 경우에는 출발 도시에서 바로 갈 수 있는 도시를 출력
        if (distance == 1) {
            for (int i : map.get(startingCity)) {
                sb.append(i + "\n");
                flag = true;
            }
            if (flag) System.out.println(sb);
            else System.out.println(-1);
        } else {
            // 거리가 1보다 큰 경우, 출발 도시에서 바로 갈 수 있는 도시들을 큐에 추가
            for (int i : map.get(startingCity)) {
                ArrayList<Integer> counter = new ArrayList<>();
                counter.add(1);
                q.add(new ArrayList[] {map.get(i), counter});
                visited[i] = true;
            }
            while (!q.isEmpty()) {
                ArrayList<Integer>[] list = q.poll();
                ArrayList<Integer> arr = list[0];
                int count = list[1].get(0);
                // 거리가 일치하는 경우, 출력할 리스트에 추가
                if (count == distance) {
                    for (int i : arr) {
                        if (!visited[i]) {
                            sb.append(i + "\n");
                            flag = true;
                        }
                    }
                } else if (count < distance){
                    // 거리가 일치하지 않는 경우, 다음으로 갈 수 있는 도시들을 큐에 추가
                    for (int i : arr) {
                        if (!visited[i]) {
                            ArrayList<Integer> counter = new ArrayList<>();
                            counter.add(count + 1);
                            q.add(new ArrayList[] {map.get(i), counter});
                            visited[i] = true;
                        }
                    }
                }
            }
            if (flag) System.out.println(sb);
            else System.out.println(-1);
        }
    }
}

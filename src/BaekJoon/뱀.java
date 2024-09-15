package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀 {

    static int[] xd = {0, 1, 0, -1}; // 동, 남, 서, 북
    static int[] yd = {1, 0, -1, 0};
    static int d = 0; // 처음에는 동쪽을 향함

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tk.nextToken());
        // map 크기
        int[][] map = new int[N][N];
        map[0][0] = -1; // 뱀이 처음 위치하는 곳

        // 사과 개수
        tk = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(tk.nextToken());

        // 사과 입력
        for (int i = 0; i < K; i++) {
            tk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tk.nextToken()) - 1;
            int y = Integer.parseInt(tk.nextToken()) - 1;
            map[x][y] = 1; // 사과 위치
        }

        // 뱀 방향전환
        tk = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(tk.nextToken());

        // 방향 입력
        HashMap<Integer, Character> direction = new HashMap<>();
        for (int i = 0; i < L; i++) {
            tk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(tk.nextToken());
            direction.put(s, tk.nextToken().charAt(0));
        }

        System.out.println(snake(map, direction));
    }

    public static int snake(int[][] map, HashMap<Integer, Character> direction) {
        Queue<int[]> snakeBody = new LinkedList<>();
        snakeBody.add(new int[]{0, 0}); // 뱀의 초기 위치
        int time = 0;
        int x = 0, y = 0;

        while (true) {
            time++;
            x += xd[d];
            y += yd[d];

            // 벽에 닿으면 게임 종료
            if (x < 0 || x >= map.length || y < 0 || y >= map[0].length) break;

            // 뱀의 몸에 닿으면 게임 종료
            if (map[x][y] == -1) break;

            // 사과가 있으면 뱀의 몸을 늘린다
            if (map[x][y] == 1) {
                snakeBody.add(new int[]{x, y});
            }
            // 사과가 없으면 몸을 늘리고 꼬리 부분을 줄인다
            else {
                snakeBody.add(new int[]{x, y});
                int[] tail = snakeBody.poll();
                map[tail[0]][tail[1]] = 0; // 꼬리 비우기
            }

            // 새로운 뱀의 머리 위치를 -1로 표시
            map[x][y] = -1;

            // 해당 시간에 방향전환이 있으면 실행한다
            if (direction.containsKey(time)) {
                directionChanger(direction.get(time));
            }
        }

        return time;
    }

    public static void directionChanger(Character c) {
        if (c == 'D') {
            d = (d + 1) % 4; // 오른쪽 회전
        } else {
            d = (d + 3) % 4; // 왼쪽 회전
        }
    }
}

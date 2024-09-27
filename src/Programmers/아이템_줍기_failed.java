package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 아이템_줍기_failed {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        int[] xd = {1, -1, 0, 0};
        int[] yd = {0, 0, 1, -1};

        // 1. 두 배 크기로 맵을 그려준다
        int[][] map = new int[102][102];

        // 2. 맵에 직사각형을 그려준다
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            // 직사각형 그리기
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    map[i][j] = 1;
                }
            }
        }

        // 3. 직사각형 내의 좌표 주변 빈 공간이 있으면 테두리로 표시해준다
        for (int i = 1; i < map.length - 1; i++) {
            for (int j = 1; j < map[0].length - 1; j++) {
                if (map[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + xd[k];
                        int y = j + yd[k];
                        if (map[x][y] == 0) {
                            map[i][j] = 2; // 테두리로 표시
                            break;
                        }
                    }
                }
            }
        }

        // 4. BFS로 최단거리를 찾는다
        int cX = characterX * 2;
        int cY = characterY * 2;
        int targetX = itemX * 2;
        int targetY = itemY * 2;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[102][102];
        q.add(new int[] {cX, cY, 0});
        visited[cX][cY] = true; // 방문 처리

        while(!q.isEmpty()) {
            int[] location = q.poll();
            int x = location[0];
            int y = location[1];
            int count = location[2];

            for (int i = 0; i < 4; i++) {
                int newX = x + xd[i];
                int newY = y + yd[i];

                // 좌표가 맵을 벗어나지 않도록 검사
                if (newX < 0 || newX >= 102 || newY < 0 || newY >= 102) {
                    continue;
                }

                // 아이템 위치에 도달한 경우
                if (newX == targetX && newY == targetY) {
                    return (count + 1) / 2;
                }

                // 테두리(2) 위에서만 탐색, 방문하지 않은 경우만 큐에 추가
                if (map[newX][newY] == 2 && !visited[newX][newY]) {
                    q.add(new int[] {newX, newY, count + 1});
                    visited[newX][newY] = true; // 큐에 넣을 때 바로 방문 처리
                }
            }
        }

        return -1; // 경로를 찾지 못한 경우
    } // solution() ends
}

package Programmers;
import java.util.*;

public class 석유_시추 {
    private static final int[] dx = {0, 0, 1, -1}; // 상하좌우 방향
    private static final int[] dy = {1, -1, 0, 0};

    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] columnToChunk = new int[m][2]; // 각 열이 속한 덩어리의 합산된 크기
        Map<Integer, Integer> chunkSizeMap = new HashMap<>(); // 덩어리 ID와 그 크기를 저장

        int chunkId = 1;
        // 석유 덩어리를 BFS로 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int size = bfs(land, visited, i, j, n, m, chunkId);
                    chunkSizeMap.put(chunkId, size);
                    chunkId++;
                }
            }
        }

        // 각 열에 해당하는 덩어리 크기를 합산
        for (int j = 0; j < m; j++) {
            Set<Integer> includedChunks = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (land[i][j] > 0) {
                    includedChunks.add(land[i][j]);
                }
            }
            int totalSize = 0;
            for (int id : includedChunks) {
                totalSize += chunkSizeMap.get(id);
            }
            columnToChunk[j][0] = totalSize;
        }

        // 최대 석유량 계산
        int maxOil = 0;
        for (int j = 0; j < m; j++) {
            maxOil = Math.max(maxOil, columnToChunk[j][0]);
        }

        return maxOil;
    }

    private int bfs(int[][] land, boolean[][] visited, int x, int y, int n, int m, int chunkId) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int oilSize = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];
            oilSize++;
            land[curX][curY] = chunkId; // 해당 위치를 덩어리 ID로 표시

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && land[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return oilSize;
    }
}

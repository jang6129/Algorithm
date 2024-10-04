package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class game_2048_Easy {

    static int N;
    static int[][] map;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(map, 0);
        System.out.println(max);
    }

    static int[][] move(int[][] map, int direction) {
        int[][] newMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, newMap[i], 0, N);
        }

        boolean[][] merged = new boolean[N][N];

        switch (direction) {
            case 0: // 상
                for (int col = 0; col < N; col++) {
                    for (int row = 1; row < N; row++) {
                        if (newMap[row][col] != 0) {
                            int currentRow = row;
                            while (currentRow > 0 && newMap[currentRow - 1][col] == 0) {
                                newMap[currentRow - 1][col] = newMap[currentRow][col];
                                newMap[currentRow][col] = 0;
                                currentRow--;
                            }
                            if (currentRow > 0 && newMap[currentRow - 1][col] == newMap[currentRow][col] && !merged[currentRow - 1][col]) {
                                newMap[currentRow - 1][col] *= 2;
                                newMap[currentRow][col] = 0;
                                merged[currentRow - 1][col] = true;
                            }
                        }
                    }
                }
                break;
            case 1: // 하
                for (int col = 0; col < N; col++) {
                    for (int row = N - 2; row >= 0; row--) {
                        if (newMap[row][col] != 0) {
                            int currentRow = row;
                            while (currentRow < N - 1 && newMap[currentRow + 1][col] == 0) {
                                newMap[currentRow + 1][col] = newMap[currentRow][col];
                                newMap[currentRow][col] = 0;
                                currentRow++;
                            }
                            if (currentRow < N - 1 && newMap[currentRow + 1][col] == newMap[currentRow][col] && !merged[currentRow + 1][col]) {
                                newMap[currentRow + 1][col] *= 2;
                                newMap[currentRow][col] = 0;
                                merged[currentRow + 1][col] = true;
                            }
                        }
                    }
                }
                break;
            case 2: // 좌
                for (int row = 0; row < N; row++) {
                    for (int col = 1; col < N; col++) {
                        if (newMap[row][col] != 0) {
                            int currentCol = col;
                            while (currentCol > 0 && newMap[row][currentCol - 1] == 0) {
                                newMap[row][currentCol - 1] = newMap[row][currentCol];
                                newMap[row][currentCol] = 0;
                                currentCol--;
                            }
                            if (currentCol > 0 && newMap[row][currentCol - 1] == newMap[row][currentCol] && !merged[row][currentCol - 1]) {
                                newMap[row][currentCol - 1] *= 2;
                                newMap[row][currentCol] = 0;
                                merged[row][currentCol - 1] = true;
                            }
                        }
                    }
                }
                break;
            case 3: // 우
                for (int row = 0; row < N; row++) {
                    for (int col = N - 2; col >= 0; col--) {
                        if (newMap[row][col] != 0) {
                            int currentCol = col;
                            while (currentCol < N - 1 && newMap[row][currentCol + 1] == 0) {
                                newMap[row][currentCol + 1] = newMap[row][currentCol];
                                newMap[row][currentCol] = 0;
                                currentCol++;
                            }
                            if (currentCol < N - 1 && newMap[row][currentCol + 1] == newMap[row][currentCol] && !merged[row][currentCol + 1]) {
                                newMap[row][currentCol + 1] *= 2;
                                newMap[row][currentCol] = 0;
                                merged[row][currentCol + 1] = true;
                            }
                        }
                    }
                }
                break;
        }

        return newMap;
    }

    static void dfs(int[][] map, int depth) {
        if (depth == 5) {
            max = Math.max(max, findMax(map));
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] newMap = move(map, i);
            dfs(newMap, depth + 1);
        }
    }

    static int findMax(int[][] map) {
        int maxBlock = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxBlock = Math.max(maxBlock, map[i][j]);
            }
        }
        return maxBlock;
    }
}

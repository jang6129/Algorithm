package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨_배달 {

    static int mapSize;
    static int n;
    static int answer = Integer.MAX_VALUE;
    static ArrayList<int[]> houses = new ArrayList<>(); // 집 좌표 저장
    static ArrayList<int[]> chickens = new ArrayList<>(); // 치킨집 좌표 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        mapSize = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int[][] map = new int[mapSize][mapSize];

        // 맵을 입력받고 치킨집과 집의 좌표를 저장
        for (int i = 0; i < mapSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    houses.add(new int[]{i, j}); // 집 좌표 추가
                } else if (map[i][j] == 2) {
                    chickens.add(new int[]{i, j}); // 치킨집 좌표 추가
                }
            }
        }

        // 최대 n개의 치킨집을 선택하는 재귀 함수 호출
        selectChicken(new ArrayList<>(), 0);
        System.out.println(answer);
    }

    // 재귀적으로 치킨집을 선택하는 함수
    static void selectChicken(ArrayList<int[]> selectedChickens, int start) {
        // 치킨집이 n개 선택되면 치킨 거리를 계산
        if (selectedChickens.size() == n) {
            answer = Math.min(answer, calculateChickenDistance(selectedChickens));
            return;
        }

        // 조합 방식으로 치킨집을 선택
        for (int i = start; i < chickens.size(); i++) {
            selectedChickens.add(chickens.get(i)); // 치킨집 선택
            selectChicken(selectedChickens, i + 1); // 재귀 호출로 다음 치킨집 선택
            selectedChickens.remove(selectedChickens.size() - 1); // 백트래킹
        }
    }

    // 선택된 치킨집들로부터 모든 집의 치킨 거리를 계산하는 함수
    static int calculateChickenDistance(ArrayList<int[]> selectedChickens) {
        int totalDistance = 0;

        // 모든 집에 대해
        for (int[] house : houses) {
            int minDistance = Integer.MAX_VALUE;

            // 각 집에 대해 선택된 치킨집 중 가장 가까운 거리 찾기
            for (int[] chicken : selectedChickens) {
                int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                minDistance = Math.min(minDistance, distance);
            }

            // 해당 집의 최소 치킨 거리를 더해줌
            totalDistance += minDistance;
        }

        return totalDistance;
    }
}

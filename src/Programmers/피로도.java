package Programmers;

public class 피로도 {
//    private int maxDungeons = 0;
//
//    public int solution(int k, int[][] dungeons) {
//        boolean[] visited = new boolean[dungeons.length];
//        exploreDungeons(k, dungeons, visited, 0);
//        return maxDungeons;
//    }
//
//    private void exploreDungeons(int k, int[][] dungeons, boolean[] visited, int count) {
//        // 현재까지 탐험한 던전 수로 maxDungeons를 갱신
//        maxDungeons = Math.max(maxDungeons, count);
//
//        // 모든 던전에 대해 시도
//        for (int i = 0; i < dungeons.length; i++) {
//            if (!visited[i] && k >= dungeons[i][0]) { // 방문하지 않았고, 최소 피로도 조건을 만족하면
//                visited[i] = true; // 현재 던전을 방문 표시
//                exploreDungeons(k - dungeons[i][1], dungeons, visited, count + 1); // 피로도를 소모하고 다음 던전 탐험
//                visited[i] = false; // 백트래킹을 위해 방문 표시를 되돌림
//            }
//        }
//    }


    public int max = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];

        // for (int i = 0; i < dungeons.length; i++) {
        explore(k, 0, dungeons, visited);
        // }

        return max;
    } // solution ends

    public void explore(int hp, int count, int[][] dungeons, boolean[] visited) {
        max = Math.max(max, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && hp >= dungeons[i][0]) {
                visited[i] = true;
                explore(hp - dungeons[i][1], count + 1, dungeons, visited);
                visited[i] = false;
            }
        }

    } // explore ends

}

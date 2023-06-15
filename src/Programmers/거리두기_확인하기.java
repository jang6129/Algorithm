package Programmers;

class 거리두기_확인하기 {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int[] rD = {1, 0, -1, 0};
        int[] cD = {0, 1, 0, -1};
        // 대기실 count
        for (int i = 0; i < places.length; i++) {
            // map 할당
            char[][] map = new char[5][5];
            for (int j = 0; j < 5; j++) {
                map[j] = places[i][j].toCharArray();
            }

            boolean isGood = true;

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    // 대기실 탐색
                    if (map[j][k] == 'P') {
                        // 응시자(P)를 중심으로 상하좌우 검사
                        for (int l = 0; l < 4; l++) {
                            int rr = j + rD[l];
                            int cc = k + cD[l];
                            // map 범위 넘어를 넘어가면 continue
                            if (rr < 0 || cc < 0 || rr > 4 || cc > 4) continue;
                            // 응시자의 상하좌우 안에 다른 응시자가 있으면 거리두기 X
                            if (map[rr][cc] == 'P') {isGood = false; break;}
                            // 응시자의 상하좌우 안에 빈 테이블이 있으면 테이블의 상하좌우 검사
                            if (map[rr][cc] == 'O') {
                                for (int m = 0; m < 4; m++) {
                                    int R = rr + rD[m];
                                    int C = cc + cD[m];
                                    if (R < 0 || C < 0 || R > 4 || C > 4 || (R == j && C == k)) continue;
                                    if (map[R][C] == 'P') {isGood = false; break;}
                                }
                            }
                        }
                    }
                }
            }
            if (isGood) answer[i] = 1;
            else answer[i] = 0;
        }



        return answer;
    }
}
package Programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public String solution(int n, int t, int m, String[] timetable) {

    // timetable을 오름차순 정렬하는 crews 생성
    PriorityQueue<int[]> crews = new PriorityQueue<>(
            (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            });

    // timetable을 String[] -> int[] 변환 -> crews에 입력
    for (String s : timetable) {
        String[] sToArr = s.split(":");
        int[] arrToInt = new int[2];
        for (int i = 0; i < 2; i++) {
            arrToInt[i] = Integer.parseInt(sToArr[i]);
        }
        crews.add(arrToInt);
    }
    
    // 구간별 셔틀 리스트 생성
    List<List<Integer>> shuttles = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        shuttles.add(new ArrayList<>());
    }

    // sCount로 셔틀 카운트, cCount로 승객 수 카운트하며 구간별 승객 채우기
    int sCount = 0;
    int cCount = 0;
    while (crews.isEmpty()) {
        // 승객 poll 이후 승객 수 카운트
        int[] curCrew = crews.poll();
        cCount++;
        // 만약 cCount > m 이면 sCount++, cCount = 1 으로 초기화
        if (cCount > m) {
            sCount++;
            cCount = 1;
        }
        // 셔틀이 꽉 차면 break
        if (sCount == n) break;
        // 남은 셔틀에 승객 탑승
        shuttles.get(sCount).add(curCrew);
    }
    // 막차부터 셔틀이 비었는지 검사, 비었으면 막차시간, 안 비면 마지막 crew보다 1분 빨리
    String answer = "";
    for (int i = n - 1; i >= 0; i--) {
        if (shuttles.get(i).size() < m) {
            int hour = (i+1);
        }
    }


    return answer;
}
}

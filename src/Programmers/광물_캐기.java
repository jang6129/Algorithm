package Programmers;

import java.util.Arrays;

public class 광물_캐기 {

    public int minFatigue = Integer.MAX_VALUE;

    public int solution(int[] picks, String[] minerals) {
        // 최대 5개까지 캘 수 있는 광물 단위로 처리하므로,
        // 탐색해야 할 최대 깊이는 광물 배열 길이의 5로 나눈 몫입니다.
        mine(0, 0, picks, minerals);
        return minFatigue;
    }

    // idx: 현재 탐색 중인 광물의 인덱스
    // fatigue: 현재까지 누적된 피로도
    public void mine(int idx, int fatigue, int[] picks, String[] minerals) {
        // 모든 광물을 다 캤거나 사용할 곡괭이가 없을 경우 최소 피로도 갱신
        if (idx >= minerals.length || Arrays.stream(picks).allMatch(p -> p == 0)) {
            minFatigue = Math.min(minFatigue, fatigue);
            return;
        }

        // 곡괭이 배열을 복사하여 상태 보존
        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                int[] newPicks = Arrays.copyOf(picks, picks.length);
                newPicks[i]--;  // 현재 곡괭이 하나 사용
                int newFatigue = fatigue;

                // 5개의 광물 또는 남은 광물만큼 캡니다.
                for (int j = idx; j < Math.min(idx + 5, minerals.length); j++) {
                    switch (minerals[j]) {
                        case "diamond":
                            if (i == 0) newFatigue += 1;    // 다이아 곡괭이
                            else if (i == 1) newFatigue += 5; // 철 곡괭이
                            else newFatigue += 25;           // 돌 곡괭이
                            break;
                        case "iron":
                            if (i == 0) newFatigue += 1;
                            else if (i == 1) newFatigue += 1;
                            else newFatigue += 5;
                            break;
                        case "stone":
                            newFatigue += 1; // 어떤 곡괭이로 캐도 돌은 피로도 1
                            break;
                    }
                }

                // 다음 광물을 캐기 위해 재귀 호출
                mine(idx + 5, newFatigue, newPicks, minerals);
            }
        }
    }
}

package BaekJoon.정렬;

import java.io.*;
import java.util.*;

public class 좌표_압축 {
    public static void main(String[] args) throws IOException {
        // BufferedReader와 BufferedWriter 사용으로 입출력 속도 최적화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 줄 입력: 좌표의 개수 N
        int N = Integer.parseInt(br.readLine());

        // 두 번째 줄 입력: 좌표 리스트
        int[] original = new int[N];
        int[] sorted = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 값을 original, sorted 배열에 저장
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            original[i] = value;
            sorted[i] = value;
        }

        // sorted 배열을 정렬하여 중복 없는 순위 지정 준비
        Arrays.sort(sorted);

        // HashMap으로 각 값의 순위(인덱스) 매핑
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        for (int value : sorted) {
            if (!rankMap.containsKey(value)) {
                rankMap.put(value, rank);
                rank++;
            }
        }

        // original 배열의 각 값에 해당하는 순위 값을 가져와 출력
        for (int value : original) {
            bw.write(rankMap.get(value) + " ");
        }

        // 버퍼 비우기 및 종료
        bw.flush();
        bw.close();
        br.close();
    }
}

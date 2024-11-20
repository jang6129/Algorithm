package BaekJoon.재귀;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 알고리즘_수업_병합_정렬_1 {
    // 저장 횟수를 기록하기 위한 변수와 K번째 값을 저장할 변수
    private static int count = 0;
    private static int K;
    private static int result = -1;

    // mergeSort 메서드: 배열 A[p..r]을 오름차순으로 정렬합니다.
    public static void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2; // 중간 지점 계산
            mergeSort(A, p, q);      // 전반부 정렬
            mergeSort(A, q + 1, r);  // 후반부 정렬
            merge(A, p, q, r);       // 병합
        }
    }

    // merge 메서드: 배열 A[p..q]와 A[q+1..r]을 병합하여 A[p..r]을 오름차순으로 정렬합니다.
    private static void merge(int[] A, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;
        int[] tmp = new int[r - p + 1]; // 임시 배열 선언 (크기는 p부터 r까지)

        // 두 부분 배열을 비교하여 tmp에 오름차순으로 저장
        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }

        // 왼쪽 배열이 남아있는 경우 tmp에 추가
        while (i <= q) {
            tmp[t++] = A[i++];
        }

        // 오른쪽 배열이 남아있는 경우 tmp에 추가
        while (j <= r) {
            tmp[t++] = A[j++];
        }

        // 정렬된 tmp 배열을 A[p..r]에 복사하면서 저장 횟수를 기록
        for (t = 0, i = p; i <= r; ++i, ++t) {
            A[i] = tmp[t];
            count++;
            if (count == K) {
                result = A[i];
            }
        }
    }

    // 테스트용 메인 메서드
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        mergeSort(A, 0, A.length - 1);
        System.out.println(result);
    }
}

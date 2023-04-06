package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Num11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int K = Integer.parseInt(tk.nextToken());
        int[] arr = new int[N];

        tk = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }


    }

    public static void quickSort(int[] arr, int K, int start, int end) {
        // 정렬할 인덱스가 남았는지 확인
        if (start < end) {
            // 시작점과 끝점의 중간지점을 pivot으로 지정
            int pivot = start + end / 2;
            // start 또는 end가 pivot값과 같아질 때까지 정렬
            while (pivot != start && pivot != end) {
                // start 지점의 값이 pivot 지점의 값보다 크고, end 지점의 값이 pivot
                // 지점의 값보다 작을 때, start 지점의 값과 end 지점의 값을 교환
                if (arr[start] > arr[pivot] && arr[end] < arr[pivot]) {
                    int temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;
                    start++;
                    end--;
                }

            }

        }

    } // quickSort ends

} // class ends

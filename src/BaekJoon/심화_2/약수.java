package BaekJoon.심화_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 약수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);

        System.out.println(arr[0] * arr[n - 1]);
    }

}

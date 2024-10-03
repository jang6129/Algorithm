package exercise;

import java.util.ArrayList;

public class CombinationExample {

    public static void main(String[] args) {
        ArrayList<Integer> selectedNumbers = new ArrayList<>();
        int[] numbers = {1, 2, 3, 4};
        int n = 2; // 2개의 숫자를 선택

        // 재귀 함수를 통해 조합을 구함
        combination(selectedNumbers, numbers, 0, n);
    }

    // 조합을 구하는 재귀 함수
    static void combination(ArrayList<Integer> selected, int[] numbers, int start, int n) {
        // 기저 조건: 선택된 숫자의 개수가 n개가 되면 출력
        if (selected.size() == n) {
            System.out.println(selected);
            return;
        }

        // 가능한 모든 숫자를 선택
        for (int i = start; i < numbers.length; i++) {
            selected.add(numbers[i]); // 숫자 선택
            combination(selected, numbers, i + 1, n); // 다음 숫자 선택 (재귀 호출)
            System.out.println("return 백트래킹");
            selected.remove(selected.size() - 1); // 백트래킹 (마지막 선택을 제거)
        }
    }
}


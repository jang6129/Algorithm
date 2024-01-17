package Programmers;

public class N개의_최소공배수 {
    public int solution(int[] arr) {
        int biggestNumber = arr[arr.length - 1];
        int answer = biggestNumber;
        int count = 1;
        while(true) {
            boolean checker = true;
            for (int i = 0; i < arr.length - 1; i++) {
                answer = count * biggestNumber;
                if (answer % arr[i] != 0) checker = false;
            }
            if (checker) break;
            else count++;
        }

        return answer;
    }
}

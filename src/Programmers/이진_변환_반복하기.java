package Programmers;

public class 이진_변환_반복하기 {
    private int countZero(String s) {
        char[] arr = s.toCharArray();
        int zeros = 0;

        for (char c : arr) {
            if (c == '0') zeros++;
        }

        return zeros;
    }

    public int[] solution(String s) {

        int looped = 0;
        int removed = 0;
        while(!s.equals("1")) {
            int zeros = countZero(s);
            int ones = s.length() - zeros;
            s = Integer.toString(ones, 2);

            removed += zeros;
            looped++;
        }


        int[] answer = {looped, removed};
        return answer;
    }
}

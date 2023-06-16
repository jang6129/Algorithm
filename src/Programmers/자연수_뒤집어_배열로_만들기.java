package Programmers;

public class 자연수_뒤집어_배열로_만들기 {
    public int[] solution(long n) {
        String input = Long.toString(n);

        int[] answer = new int[input.length()];
        int index = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            answer[index++] = (int)input.charAt(i) - '0';
        }

        return answer;
    }
}

//class Solution {
//    public int[] solution(long n) {
//        String input = Long.toString(n);
//        String str = new StringBuilder(input).reverse().toString();
//        char[] list = str.toCharArray();
//
//        int[] answer = new int[list.length];
//        for (int i = 0; i < list.length; i++) {
//            answer[i] = list[i] - '0';
//        }
//
//        return answer;
//    }
//}
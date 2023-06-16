package Programmers;

import java.util.StringTokenizer;

public class 이상한_문자_만들기 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isUpper = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append(' ');
                isUpper = true;
            } else {
                if (isUpper) sb.append(Character.toUpperCase(c));
                else sb.append(Character.toLowerCase(c));
                isUpper = !isUpper;
            }
        }

        String answer = sb.toString();
        return answer;
    }
}

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");

        for (String str : arr) {
            for (int i = 0; i < str.length(); i++) {
                if (i % 2 == 0) sb.append(Character.toUpperCase(str.charAt(i)));
                else sb.append(Character.toLowerCase(str.charAt(i)));
            }
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);


        String answer = sb.toString();
        return answer;
    }
}
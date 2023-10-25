package Programmers;
import java.util.*;

public class 문자열_압축 {

    private List<String> split(String s, int length) {
        List<String> list = new ArrayList<>();

        for (int startIndex = 0; startIndex < s.length(); startIndex += length) {
            int endIndex = startIndex + length;
            if (endIndex >= s.length()) endIndex = s.length();
            list.add(s.substring(startIndex, endIndex));
        }

        return list;
    }

    private int compress(String s, int length) {
        List<String> list = split(s, length);
        StringBuilder sb = new StringBuilder();

        String last = "";
        int count = 0;
        for (String str : list) {
            if (str.equals(last)) {
                count++;
            } else {
                if (count > 1) sb.append(count);
                sb.append(last);
                last = str;
                count = 1;
            }
        }
        if (count > 1) sb.append(count);
        sb.append(last);

        return sb.length();
    }

    public int solution(String s) {

        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= s.length(); i++) {
            answer = Math.min(answer, compress(s, i));
        }


        return answer;
    }
}

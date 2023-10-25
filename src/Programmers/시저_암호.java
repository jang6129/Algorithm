package Programmers;

public class 시저_암호 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();

        for (char c : arr) {
            if (c == ' ') sb.append(' ');
            else {
                int offset = Character.isUpperCase(c)? 'A' : 'a';
                int position = (c - offset + n) % ('Z' - 'A' + 1);
                sb.append((char)(offset + position));
            }
        }

        String answer = sb.toString();
        return answer;
    }
}


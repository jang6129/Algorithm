package Programmers;

public class 문자열_내_p와_y의_개수 {
    boolean solution(String s) {

        char[] arr = s.toCharArray();
        int p = 0;
        int y = 0;
        for (char c : arr) {
            if (c == 'p' || c == 'P') p++;
            else if (c == 'y' || c == 'Y') y++;
        }

        return p == y;
    }
}

package Programmers;

import java.util.ArrayList;
import java.util.Collections;

public class 모음사전 {
    String[] alpha = {"A", "E", "I", "O", "U"};
    ArrayList<String> words = new ArrayList<>();

    public int solution(String word) {
        for (String s : alpha) {
            recur(s);
        }

        Collections.sort(words);

        return words.indexOf(word) + 1;
    } // solution ends

    public void recur(String s) {
        if (s.length() > 5) return;
        words.add(s);

        for (String a : alpha) {
            recur(s+a);
        }
    } // recur ends
}

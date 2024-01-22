package Programmers;

import java.util.HashSet;
import java.util.Set;

public class 스킬트리 {
    static Set<Character> charSet = new HashSet<>();
    static int answer = 0;

    public int solution(String skill, String[] skill_trees) {

        for (int i = 0 ; i < skill.length(); i++) {
            charSet.add(skill.charAt(i));
        }

        for (String tree : skill_trees) {
            String target = filter(tree);
            if (tester(skill, target)) answer++;
        }

        return answer;
    } // solution ends

    public String filter(String tree) {
        String filtered = "";
        for (int i = 0; i < tree.length(); i++) {
            if (charSet.contains(tree.charAt(i))) {
                filtered += tree.charAt(i);
            }
        }

        return filtered;
    } // filter ends

    public boolean tester(String original, String target) {
        for (int i = 0; i < target.length(); i++) {
            if (original.charAt(i) != target.charAt(i)) return false;
        }
        return true;
    }
}

package Programmers;

public class 단어_변환 {
    static int answer = Integer.MAX_VALUE;
    static boolean[] wordUsed;

    public int solution(String begin, String target, String[] words) {
        wordUsed = new boolean[words.length];

        for (int i = 0; i < words.length; i++) {
            if (isConvertible(begin, words[i])) {
                wordUsed[i] = true;
                dfs(words[i], target, words, 1);
            }
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    static void dfs(String begin, String target, String[] words, int count) {
        if (begin.equals(target)) {
            answer = Math.min(count, answer);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!wordUsed[i] && isConvertible(begin, words[i])) {
                wordUsed[i] = true;
                dfs(words[i], target, words, count + 1);
                wordUsed[i] = false;
            }
        }
    }

    static boolean isConvertible(String target, String comparison) {
        int counter = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) != comparison.charAt(i)) counter++;
        }

        if (counter == 1) return true;
        else return false;
    }
}

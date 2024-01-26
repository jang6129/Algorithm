package Programmers;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int width = 3; width <= 5000; width++) {
            for (int height = 3; height <= width; height++) {
                int b = (width + height - 2) * 2;
                int y = width * height - b;
                if (b == brown && y == yellow) {
                    answer[0] = width;
                    answer[1] = height;
                }
            }
        }

        return answer;
    }
}

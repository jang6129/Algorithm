package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 너의_평점은 {
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            float totalCredits = 0;
            float totalPoints = 0;

            for (int i = 0; i < 20; i++) {
                String[] input = br.readLine().split(" ");
                String grade = input[2];
                float credit = Float.parseFloat(input[1]);

                if (grade.equals("P")) {
                    continue;
                }

                float gradePoint = 0;
                switch (grade) {
                    case "A+":
                        gradePoint = 4.5f;
                        break;
                    case "A0":
                        gradePoint = 4.0f;
                        break;
                    case "B+":
                        gradePoint = 3.5f;
                        break;
                    case "B0":
                        gradePoint = 3.0f;
                        break;
                    case "C+":
                        gradePoint = 2.5f;
                        break;
                    case "C0":
                        gradePoint = 2.0f;
                        break;
                    case "D+":
                        gradePoint = 1.5f;
                        break;
                    case "D0":
                        gradePoint = 1.0f;
                        break;
                    case "F":
                        gradePoint = 0.0f;
                        break;
                }

                totalPoints += gradePoint * credit;
                totalCredits += credit;
            }

            if (totalCredits == 0) {
                System.out.println("0.000000");
            } else {
                System.out.printf("%.6f\n", totalPoints / totalCredits);
            }
        }
    }
}
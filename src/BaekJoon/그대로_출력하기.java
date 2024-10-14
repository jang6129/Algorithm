package BaekJoon;

import java.util.Scanner;

public class 그대로_출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // EOF까지 입력을 받으면서 그대로 출력
        while (sc.hasNextLine()) {
            String line = sc.nextLine();  // 한 줄 입력
            System.out.println(line);     // 그대로 출력
        }

        sc.close();
    }
}

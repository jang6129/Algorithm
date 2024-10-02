package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 톱니바퀴 {

    static Wheel wheel1;
    static Wheel wheel2;
    static Wheel wheel3;
    static Wheel wheel4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String wheel = br.readLine();
        int[] numbers = new int[wheel.length()];
        int top = 0;
        int left = 0;
        int right = 0;
        for(int i = 0; i < wheel.length(); i++) {
            if (i == 0) top = wheel.charAt(i) - '0';
            else if (i == 2) right = wheel.charAt(i) - '0';
            else if (i == 6) left = wheel.charAt(i) - '0';
            numbers[i] = wheel.charAt(i) - '0';
        }
        wheel1 = new Wheel(top, left, right, numbers);

        wheel = br.readLine();
        for(int i = 0; i < wheel.length(); i++) {
            if (i == 0) top = wheel.charAt(i) - '0';
            else if (i == 2) right = wheel.charAt(i) - '0';
            else if (i == 6) left = wheel.charAt(i) - '0';
            numbers[i] = wheel.charAt(i) - '0';
        }
        wheel2 = new Wheel(left, top, right, numbers);

        wheel = br.readLine();
        for(int i = 0; i < wheel.length(); i++) {
            if (i == 0) top = wheel.charAt(i) - '0';
            else if (i == 2) right = wheel.charAt(i) - '0';
            else if (i == 6) left = wheel.charAt(i) - '0';
            numbers[i] = wheel.charAt(i) - '0';
        }
        wheel3 = new Wheel(left, top, right, numbers);

        wheel = br.readLine();
        for(int i = 0; i < wheel.length(); i++) {
            if (i == 0) top = wheel.charAt(i) - '0';
            else if (i == 2) right = wheel.charAt(i) - '0';
            else if (i == 6) left = wheel.charAt(i) - '0';
            numbers[i] = wheel.charAt(i) - '0';
        }
        wheel4 = new Wheel(left, top, right, numbers);

        int rotateN = Integer.parseInt(br.readLine());

        for (int i = 0; i < rotateN; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rotate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), new boolean[5]);
        }

        int score = 0;
        if (wheel1.numbers[wheel1.top] == 1) score += 1;
        if (wheel2.numbers[wheel2.top] == 1) score += 2;
        if (wheel3.numbers[wheel3.top] == 1) score += 4;
        if (wheel4.numbers[wheel4.top] == 1) score += 8;
        System.out.println(score);
    }

    static void rotate(int wheelN, int direction, boolean[] rotated) {
        if (rotated[wheelN]) return;
        rotated[wheelN] = true;

        switch (wheelN) {
            case(1): {
                // 2와 극이 같으면 멈춘다
                if (wheel1.right == wheel2.left) return;
                // 2에서 넘어왔으면 멈춘다
                else if (rotated[2]) return;
                // 1에서 시작했으면 돌고 2도 돌린다
                else {
                    rotater(wheel1, direction);
                    rotater(wheel2, -direction);
                    rotate(2, -direction, rotated);
                }
                break;
            }
            case(2): {
                // 1에서 왔으면 3과 비교한다
                if (rotated[1]) {
                    // 3과 극이 같으면 멈춘다
                    if (wheel2.right == wheel3.left) return;
                    // 극이 다르면 3을 돌린다
                    else {
                        rotater(wheel3, -direction);
                        rotate(3, -direction, rotated);
                    }
                }
                // 3에서 왔으면 1과 비교한다
                else if (rotated[3]) {
                    // 1과 극이 같으면 멈춘다
                    if (wheel2.left == wheel1.right) return;
                    // 극이 다르면 1을 돌린다
                    else rotater(wheel1, -direction);
                }
                // 2에서 시작했으면 1, 3과 비교한다
                else if (!rotated[1] && !rotated[3]) {
                    // 1, 3 모두와 극이 다르면 다 돌린다
                    if (wheel1.right != wheel2.left && wheel2.right != wheel3.left) {
                        rotater(wheel2, direction);
                        rotater(wheel1, -direction);
                        rotater(wheel3, -direction);
                        rotate(3, -direction, rotated);
                    }
                    // 1 하고만 다르면 1, 2만 돌린다
                    else if (wheel1.right != wheel2.left) {
                        rotater(wheel2, direction);
                        rotater(wheel1, -direction);
                    }
                    // 3하고만 다르면 2, 3만 돌린다
                    else if (wheel2.right != wheel3.left) {
                        rotater(wheel2, direction);
                        rotater(wheel3, -direction);
                        rotate(3, -direction, rotated);
                    }
                    // 다 같으면 멈춘다
                    else return;
                }
                break;
            }
            case(3): {

            }
            case(4): {

            }
        } // switch ends

    }

    static void rotater(Wheel wheel, int direction) {
        if (direction == 1) {
            wheel.top = (wheel.top + 1) % 8;
            wheel.left = (wheel.left + 1) % 8;
            wheel.right = (wheel.right + 1) % 8;
        }
        else {
            wheel.top = (wheel.top - 1 + 8) % 8;
            wheel.left = (wheel.left - 1 + 8) % 8;
            wheel.right = (wheel.right - 1 + 8) % 8;
        }
    }

    static class Wheel {
        int top;
        int left;
        int right;
        int[] numbers;
        public Wheel(int top, int left, int right, int[] numbers) {
            this.top = top;
            this.left = left;
            this.right = right;
            this.numbers = numbers;
        }
    }

}

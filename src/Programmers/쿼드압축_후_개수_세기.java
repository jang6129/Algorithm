package Programmers;

public class 쿼드압축_후_개수_세기 {
    static int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        compressor(arr, 0, 0, arr.length);

        return answer;
    } // solution ends.

    public void compressor(int[][] arr, int initX, int initY, int size) {
        if (isIdentical(arr, initX, initY, size)) {
            answer[arr[initX][initY]]++;
            return;
        }
        compressor(arr, initX, initY, size/2);
        compressor(arr, initX + size/2, initY, size/2);
        compressor(arr, initX, initY + size/2, size / 2);
        compressor(arr, initX + size/2, initY + size/2, size / 2);
    } // compressor ends.

    public boolean isIdentical(int[][] arr, int initX, int initY, int size) {
        for (int i = initX; i < initX + size; i++) {
            for (int j = initY; j < initY + size; j++) {
                if (arr[initX][initY] != arr[i][j]) return false;
            }
        }
        return true;
    } // isIdentical ends.
}

package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구슬_탈출_2 {

    static class Red {
        public int x;
        public int y;

        public Red(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Blue {
        public int x;
        public int y;

        public Blue(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] xd = {1, 0, -1, 0};
    static int[] yd = {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tk.nextToken());
        int M = Integer.parseInt(tk.nextToken());

        Red red = new Red(0, 0);
        Blue blue = new Blue(0, 0);

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (str.charAt(j) == 'R') red = new Red(i, j);
                else if (str.charAt(j) == 'B') blue = new Blue(i, j);
            }
        }

        gravity(red, blue, map, 0);

        if (answer > 10) System.out.println(-1);
        else System.out.println(answer);
    }  // main ends

    static void gravity(Red red, Blue blue, char[][] map, int count) {
        if (count > 10) return;

        for (int i = 0; i < 4; i++) {
            Red newRed = new Red(red.x, red.y);
            Blue newBlue = new Blue(blue.x, blue.y);
            boolean flagB = false;
            boolean flagR = false;
            for (int j = 0; j < Math.max(map.length, map[0].length); j++) {
                if (map[newBlue.x + xd[i]][newBlue.y + yd[i]] == 'O') {
                    flagB = true;
                }  else if (map[newBlue.x + xd[i]][newBlue.y + yd[i]] == '.'){
                    newBlue.x += xd[i];
                    newBlue.y += yd[i];
                }

                if (map[newRed.x + xd[i]][newRed.y + yd[i]] == 'O') {
                    flagR = true;
                } else if (map[newRed.x + xd[i]][newRed.y + yd[i]] == '.'){
                    newRed.x += xd[i];
                    newRed.y += yd[i];
                }
            }

            if(flagB && flagR) return;
            else if(!flagB && flagR) {
                answer = Math.min(answer, count + 1);
                return;
            }

            gravity(newRed, newBlue, map, count + 1);
        }

    } // gravity ends


} // Main ends

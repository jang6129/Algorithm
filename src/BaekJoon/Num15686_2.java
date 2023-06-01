package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Num15686_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int mapSize = Integer.parseInt(tk.nextToken());
        int shopNumber = Integer.parseInt(tk.nextToken());
        ArrayList<int[]> house = new ArrayList<>();
        ArrayList<int[]> shop = new ArrayList<>();

        for (int i = 1; i <= mapSize; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= mapSize; j++) {
                int n = Integer.parseInt(tk.nextToken());
                if (n==1) house.add(new int[] {i, j});
                else if (n==2) shop.add(new int[] {i, j, 0});
            }
        }



        while (shop.size() > shopNumber) {
            for (int i = 0; i < house.size(); i++) {
                int[] h = house.get(i);
                for (int j = 0; j < shop.size(); j++) {
                    int[] s = shop.get(j);
                    int distance = Math.abs(h[0] - s[0]) + Math.abs(h[1] - s[1]);
                    shop.get(j)[2] += distance;
                }
            }

            Collections.sort(shop, (s1, s2) -> {
                return s2[2] - s1[2];
            });

            shop.remove(0);
        }

        int[] lengths = new int[house.size()];
        Arrays.fill(lengths, Integer.MAX_VALUE);

        for (int i = 0; i < house.size(); i++) {
            int[] h = house.get(i);
            for (int j = 0; j < shop.size(); j++) {
                int[] s = shop.get(j);
                int distance = Math.abs(h[0] - s[0]) + Math.abs(h[1] - s[1]);
                if (distance < lengths[i]) {
                    lengths[i] = distance;
                }
            }
        }

        int answer = 0;

        for (int i : lengths) {
            answer += i;
        }

        System.out.println(answer);
    }


}

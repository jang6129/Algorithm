package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num18352_list {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int cityN = Integer.parseInt(tk.nextToken());
        int roadN = Integer.parseInt(tk.nextToken());
        int distance = Integer.parseInt(tk.nextToken());
        int startingCity = Integer.parseInt(tk.nextToken());

        ArrayList<ArrayList<Integer>> map = new ArrayList<>();

        for (int i = 0; i <= cityN; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < roadN; i++) {
            tk = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(tk.nextToken());
            int to = Integer.parseInt(tk.nextToken());
            map.get(from).add(to);
        }

        

    }
}

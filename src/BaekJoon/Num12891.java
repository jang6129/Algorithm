package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        int dnaLength = Integer.parseInt(tk.nextToken());
        int pwdLength = Integer.parseInt(tk.nextToken());
        int[] acgt = new int[4];
        int[] acgtMin = new int[4];

        String dna = br.readLine();
        tk = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            acgtMin[i] = Integer.parseInt(tk.nextToken());
        }

        int count = 0;
        for (int i = 0; i < dnaLength; i++) {
            char rearTarget = dna.charAt(i);
            if (i == pwdLength - 1) {
                switch (rearTarget) {
                    case ('A') : acgt[0]++; break;
                    case ('C') : acgt[1]++; break;
                    case ('G') : acgt[2]++; break;
                    case ('T') : acgt[3]++; break;
                }
                boolean isSuitable = true;
                for (int j = 0; j < 4; j++) {
                    if (acgt[j] < acgtMin[j]) isSuitable = false;
                }
                if (isSuitable) count++;
            }
            else if (i < pwdLength) {
                switch (rearTarget) {
                    case ('A') : acgt[0]++; break;
                    case ('C') : acgt[1]++; break;
                    case ('G') : acgt[2]++; break;
                    case ('T') : acgt[3]++; break;
                }
            } else {
                char frontTarget = dna.charAt(i - pwdLength);
                switch (frontTarget) {
                    case ('A') : acgt[0]--; break;
                    case ('C') : acgt[1]--; break;
                    case ('G') : acgt[2]--; break;
                    case ('T') : acgt[3]--; break;
                }
                switch (rearTarget) {
                    case ('A') : acgt[0]++; break;
                    case ('C') : acgt[1]++; break;
                    case ('G') : acgt[2]++; break;
                    case ('T') : acgt[3]++; break;
                }
                boolean isSuitable = true;
                for (int j = 0; j < 4; j++) {
                    if (acgt[j] < acgtMin[j]) isSuitable = false;
                }
                if (isSuitable) count++;
            }

        }


        System.out.println(count);
    }
}

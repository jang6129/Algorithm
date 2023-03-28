package BaekJoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Num1764 {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int N, M;
      ArrayList<String> intersection = new ArrayList<>();
      HashSet<String> heard = new HashSet<>();
      StringBuilder sb = new StringBuilder();

      String listSize[] = scan.nextLine().split(" ");
      N = Integer.parseInt(listSize[0]);
      M = Integer.parseInt(listSize[1]);

      for (int i = 0; i < N; i++) {
         heard.add(scan.nextLine());
      }

      for (int i = 0; i < M; i++) {
    	  String seen = scan.nextLine();
    	  if (heard.contains(seen)) {
    		  intersection.add(seen);
    	  }
      }
      
      scan.close();
      
      Collections.sort(intersection);
      
      System.out.println(intersection.size());
     
      for (String s : intersection) {
    	  sb.append(s + "\n");
      }
      
      System.out.println(sb);
   }
}
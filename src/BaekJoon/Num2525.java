package BaekJoon;

import java.util.Scanner;

public class Num2525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String time = sc.nextLine();
		String[] times = time.split(" ");
		int hour = Integer.parseInt(times[0]);
		int minute = Integer.parseInt(times[1]);
		int cook = sc.nextInt();
		int wholeTime = minute + cook;
		
		if (wholeTime / 60 >= 1) {
			hour += wholeTime / 60;
			wholeTime -= 60 * (wholeTime / 60);
			if (hour >= 24) {
				hour -= 24;
			}
		}
		
		System.out.println(hour + " " + wholeTime);
	}
}

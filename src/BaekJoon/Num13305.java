package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Num13305 {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num;
		int road[];
		int city[];
		try {
			num = Integer.parseInt(bf.readLine());
			String roadString[] = bf.readLine().split(" ");
			String cityString[] = bf.readLine().split(" ");
			road = new int[roadString.length];
			city = new int[cityString.length];
			for (int i = 0; i < roadString.length; i++) {
				road[i] = Integer.parseInt(roadString[i]);
			}
			for (int i = 0; i < cityString.length; i++) {
				city[i] = Integer.parseInt(cityString[i]);
			}
			System.out.println(function(num, road, city));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int function(int num, int road[], int city[]) {
		int counter = 0;
		ArrayList<Integer> sort = new ArrayList<>();

		for (int i = 0; i < city.length - 1; i++) {
			sort.add(city[i]);
		}

		Collections.sort(sort);
		int bestPrice = sort.get(0);

		for (int i = 0; i < road.length; i++) {
			if (city[i] <= bestPrice) {
				for (int k = i; k < road.length; k++) {
					counter += city[i] * road[k];
				}
				break;
			} else if (city[i] < city[i + 1] && i < road.length - 1) {
				counter += city[i] * road[i] * road[++i];
			} else {
				counter += city[i] * road[i];
			}
		}

		return counter;
	}
}

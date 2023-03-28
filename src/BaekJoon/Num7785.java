package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Num7785 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, String> workers = new HashMap<>();
		
		try {
			int workerNumber = Integer.parseInt(br.readLine());

			for (int i = 0; i < workerNumber; i++) {
				String[] input = br.readLine().split(" ");

				if (input[1].equals("enter")) {
					workers.put(input[0], input[0]);
				} else if (input[1].equals("leave")) {
					workers.remove(input[0]);
				}
			}
		} catch (IOException i) {
			System.out.println(i);
		}

		List<Entry<String, String>> list = new ArrayList<Entry<String, String>>(workers.entrySet());

		Collections.sort(list, new Comparator<Entry<String, String>>() {

			public int compare(Entry<String, String> obj1, Entry<String, String> obj2) {
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});

		for (Entry<String, String> entry : list) {
			System.out.println(entry.getValue());
		}
	}

}

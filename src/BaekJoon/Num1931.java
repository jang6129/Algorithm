//package BaekJoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.LinkedList;
//import java.util.PriorityQueue;
//import java.util.Queue;
//import java.util.TreeMap;
//
//public class Num1931 {
//	public static void main(String[] args) {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		int n = 0;
//		int counter = 0;
//		long currentTime = 0;
//		PriorityQueue<long[][]> queue = new PriorityQueue<long[][]>(new Comparator<long[][]>();
//
//		try {
//			n = Integer.parseInt(bf.readLine());
//			for (int i = 0; i < n; i++) {
//				String[] input = bf.readLine().split(" ");
//				long[][] inputToLong = new long[Integer.parseInt(input[1])][Integer.parseInt(input[0])];
//				queue.add(inputToLong);
//			}
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		while (!map.isEmpty()) {
//			System.out.println(map.pollFirstEntry().getKey());
//		}
//
//		if (!map.isEmpty()) {
//			currentTime = map.pollFirstEntry().getKey();
//			counter++;
//		}
//
//		while (!map.isEmpty()) {
//			if (map.firstEntry().getValue() >= currentTime) {
//				currentTime = map.pollFirstEntry().getKey();
//				counter++;
//			} else {
//				map.pollFirstEntry();
//			}
//		}
//
//		System.out.println(counter);
//
//	}
//
//	Arrays.sort(queue, new Comparator<long[]>() {
//
//		@Override
//		public int compare(long[] o1, long[] o2) {
//			// TODO Auto-generated method stub
//			return 0;
//		}
//		
//	}
//	
//}

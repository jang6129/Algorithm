package Programmers;

public class Camo {
	public static int solution(String[][] clothes) {
        int combination = clothes.length;
        int sum = 0;
		
		for (int i = 0; i < combination; i++) {
			sum += clothes[i].length;
		}
		
		
		return sum;
    }
	
	public static void main(String[] args) {
		String[][] clothes = {{"hat", "sunglasses"}, {"tshirts"}, {"jean"}, {"coat", "padding"}};
		System.out.println(solution(clothes));
	}
}

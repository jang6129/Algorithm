package Programmers;

// 접두사가 없는가? 있다면 false, 없다면 true

public class PhoneBook {
	public static boolean phoneBook(String[] phone_book) {
		boolean answer = true;
		boolean[] checker = new boolean[phone_book.length];

		for (int i = 0; i < checker.length; i++) {
			checker[i] = false;
		}

		for (int a = 0; a < phone_book.length; a++) {
			for (int b = 0; b < phone_book.length; b++) {
				if (a != b) {
					if (phone_book[a].length() > phone_book[b].length()) {
						for (int c = 0; c < phone_book[b].length(); c++) {
							if (phone_book[a].charAt(c) != phone_book[b].charAt(c)) {
								checker[b] = true;
							}
						}
					} else {
						for (int d = 0; d < phone_book[a].length(); d++) {
							if (phone_book[a].charAt(d) != phone_book[b].charAt(d)) {
								checker[a] = true;
							}
						}
					}
				}
			}
		}

		for (int f = 0; f < checker.length; f++) {
			if (checker[f] == false) {
				answer = false;
				} else {
					
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		String[] book = { "1235", "123456", "789" };
		System.out.println(phoneBook(book));
	}
}

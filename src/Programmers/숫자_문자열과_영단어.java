package Programmers;

public class 숫자_문자열과_영단어 {
//    public int solution(String s) {
//        Map<String, Integer> numbers = new HashMap<>();
//        String save = new String();
//        String answer = new String();
//        numbers.put("zero", 0);
//        numbers.put("one", 1);
//        numbers.put("two", 2);
//        numbers.put("three", 3);
//        numbers.put("four", 4);
//        numbers.put("five", 5);
//        numbers.put("six", 6);
//        numbers.put("seven", 7);
//        numbers.put("eight", 8);
//        numbers.put("nine", 9);
//        for (int i = 0; i < s.length(); i++) {
//            if ((int) s.charAt(i) < 48 || (int) s.charAt(i) > 57) {
//                save += s.charAt(i);
//                if (numbers.containsKey(save)) {
//                    answer += Integer.toString(numbers.get(save));
//                    save = "";
//                }
//            } else {
//                answer += s.charAt(i);
//                save = "";
//            }
//        }
//        return Integer.parseInt(answer);
//    }

    public int solution(String s) {
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < arr.length; i++) {
            s = s.replace(arr[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }
}

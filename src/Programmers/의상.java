package Programmers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class 의상 {

    public int solution(String[][] clothes) {
        Map<String, Integer> count = new HashMap<>();

        for (String[] cloth : clothes) {
            if (count.containsKey(cloth[1])) {
                int oldValue = count.get(cloth[1]);
                count.put(cloth[1], oldValue + 1);
            } else {
                count.put(cloth[1], 2);
            }
        }

        Collection<Integer> values = count.values();

        Integer answer = 1;
        for (Integer value : values) {
            answer *= value;
        }

        return answer - 1;
    }

}

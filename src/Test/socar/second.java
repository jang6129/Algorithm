package Test.socar;

import java.util.ArrayList;
import java.util.List;

public class second {
    private static int minEffort = Integer.MAX_VALUE;

    public static int calculateEffort(int n, int[] orders) {
        List<Integer> books = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            books.add(i);
        }
        permuteAndCalculate(books, 0, n, orders);
        return minEffort;
    }

    private static void permuteAndCalculate(List<Integer> books, int l, int r, int[] orders) {
        if (l == r) {
            minEffort = Math.min(minEffort, calculateEffortForOrder(books, orders));
        } else {
            for (int i = l; i < r; i++) {
                swap(books, l, i);
                permuteAndCalculate(books, l + 1, r, orders);
                swap(books, l, i); // backtrack
            }
        }
    }

    private static int calculateEffortForOrder(List<Integer> books, int[] orders) {
        int effort = 0;
        List<Integer> stack = new ArrayList<>(books);
        for (int order : orders) {
            int index = stack.indexOf(order);
            if (index != -1) {
                effort += index; // 각 책 묶음에서 1권을 꺼내는데 필요한 힘 계산
                // 한 묶음의 책을 모두 꺼냈을 경우 스택에서 해당 묶음 제거
                if (stack.lastIndexOf(order) == index) {
                    stack.remove(index);
                }
            }
        }
        return effort;
    }

    private static void swap(List<Integer> books, int i, int j) {
        int temp = books.get(i);
        books.set(i, books.get(j));
        books.set(j, temp);
    }

    public static void main(String[] args) {
        int n = 3;
        int[] orders = {1, 2, 1, 3, 3, 2};
        System.out.println("최소 힘의 합: " + calculateEffort(n, orders));
    }
}

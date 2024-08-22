package Test.synap;

public class quiz4 {
    public static void main(String[] args) {
        long a = 12345678999L;
        long b = 99987654321L;

        long result = fibo(a, b);
        System.out.println("피보나치 수의 합: " + result);
    }

    private static long fibo(long a, long b) {
        long fib1 = 1, fib2 = 2;
        long sum = 0;

        while (fib2 <= b) {
            if (fib2 >= a) {
                sum += fib2;
            }
            long nextFib = fib1 + fib2;
            fib1 = fib2;
            fib2 = nextFib;
        }

        return sum;
    }
}

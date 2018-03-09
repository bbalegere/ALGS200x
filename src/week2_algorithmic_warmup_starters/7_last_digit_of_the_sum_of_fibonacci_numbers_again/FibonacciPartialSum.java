//7 Last Digit of the Sum of Fibonacci Numbers Again
import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciPartialSum {

    private static long getFibonacciPartialSumNaive(long m, long n) {
        if (n <= 1)
            return n;

        //We know pisano period of 100 is 60
        int rem1 = (int) (m % 60);
        int rem2 = (int) (n % 60);

        ArrayList<Integer> fib = new ArrayList<>();
        fib.add(0);
        fib.add(1);

        int i;
        for (i = 2; i <= Math.max(rem1, rem2) + 2; i++) {
            fib.add((fib.get(i - 1) + fib.get(i - 2)) % 10);
        }

        int res1 = fib.get(rem1 + 1);
        int res2 = fib.get(rem2 + 2);
        if (res2 >= res1) {
            return res2 - res1;
        } else {
            return 10 + res2 - res1;
        }


    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}


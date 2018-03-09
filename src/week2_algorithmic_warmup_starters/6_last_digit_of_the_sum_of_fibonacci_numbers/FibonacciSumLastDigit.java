import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciSumLastDigit {

    private static long getFibonacciSum(long n) {
        if (n < 1) return 0;
        if (n <= 1) return n;

        //We know pisano period of 100 is 60
        int rem = (int) (n % 60) + 2; //Add two so that we pick up the right index on the array

        ArrayList<Integer> fib = new ArrayList<>();
        fib.add(0);
        fib.add(1);
        int i;
        for (i = 2; i <= rem; i++) {
            fib.add((fib.get(i - 1) + fib.get(i - 2)) % 10);
        }

        if (fib.get(rem) == 0) return 9;
        return fib.get(rem) - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSum(n);
        System.out.println(s);
    }
}


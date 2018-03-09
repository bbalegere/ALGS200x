//5 Fibonacci Number Again

import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        ArrayList<Long> fib = new ArrayList<>();
        fib.add((long) 0);
        fib.add((long) 1);

        int i;
        for(i=2;i<=n;i++) {
            fib.add((fib.get(i - 1) + fib.get(i - 2)) % m);
            if (fib.get(i) == 1 && fib.get(i - 1) == 0) {
                int rem = (int) (n % (i - 1));
                return fib.get(rem);
            }

        }
        return fib.get(i-1);
    }

//    private static long getFibonacciHugeNaive(long n, long m) {
//        if (n <= 1)
//            return n;
//
//        ArrayList<Long> fib = new ArrayList<>();
//        fib.add((long) 0);
//        fib.add((long) 1);
//        long n1 = n;
//
//        int i = 2;
//        while (n-- > 1) {
//            fib.add((fib.get(i - 1) + fib.get(i - 2)) % m);
//            if (fib.get(i) == 1 && fib.get(i - 1) == 0) {
//                int rem = (int) (n1 % (i - 1));
//                return fib.get(rem);
//            }
//            i++;
//        }
//        return fib.get(i - 1);
//    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}


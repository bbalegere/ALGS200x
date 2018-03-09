import java.util.Scanner;

public class Fibonacci {
    private static long calc_fib(int n) {
        if (n <= 1)
            return n;

        int n1 = 0;
        int n2 = 1;
        int result = n1 + n2;
        while (n-- > 1) {
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        return result;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
    }
}

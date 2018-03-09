import java.util.Scanner;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;


        int n1 = 0;
        int n2 = 1;
        int result = n1 + n2;
        while (n-- > 1) {
            result = (n1 + n2) % 10;
            n1 = n2;
            n2 = result;
        }


        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}


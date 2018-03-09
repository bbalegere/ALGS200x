import java.util.Scanner;

public class LCM {

    private static int gcd(int a, int b) {
        if (b == 0) return a;

        int n2 = a % b;

        return gcd(b, n2);

    }

    private static long lcm_naive(int a, int b) {

        return (long) a * b / gcd(a, b);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(lcm_naive(a, b));
    }
}

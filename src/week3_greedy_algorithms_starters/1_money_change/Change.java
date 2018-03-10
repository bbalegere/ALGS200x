import java.util.Scanner;

public class Change {
    private static int getChange(int m) {

        int coins = 0;
        int[] denoms = {10, 5, 1};
        for (int d : denoms) {
            coins += m / d;
            m = m % d;
            if (m == 0) break;
        }

        return coins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}


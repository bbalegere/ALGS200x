import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        Comparator<String> cmp = (X, Y) -> {
            int XY = Integer.parseInt(X + Y);
            int YX = Integer.parseInt(Y + X);

            return XY > YX ? -1 : 1;
        };
        Arrays.sort(a, cmp);
        StringBuilder result = new StringBuilder();

        for (String anA : a) {
            result.append(anA);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}


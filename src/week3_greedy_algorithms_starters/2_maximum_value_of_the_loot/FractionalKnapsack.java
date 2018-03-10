import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, double[][] ratios) {
        double value = 0;

        Comparator<double[]> a = (X, Y) -> X[0] / X[1] > Y[0] / Y[1] ? 1 : -1;
        Arrays.sort(ratios, a);
        int i = ratios.length - 1;
        while (capacity > 0) {
            double w = Math.min(ratios[i][1], capacity);
            value += w * ratios[i][0] / ratios[i][1];
            capacity -= (int) w;
            i--;
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        double[][] ratios = new double[n][2];
        for (int i = 0; i < n; i++) {
            ratios[i][0] = (double) scanner.nextInt();
            ratios[i][1] = (double) scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, ratios));
    }
} 

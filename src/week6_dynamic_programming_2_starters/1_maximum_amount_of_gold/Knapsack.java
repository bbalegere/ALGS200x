import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {

        int[][] opt = new int[w.length + 1][W + 1];


        for (int i = 1; i <= w.length; i++) {

            for (int j = 1; j <= W; j++) {
                opt[i][j] = opt[i - 1][j];
                if (w[i - 1] <= j) {
                    opt[i][j] = Math.max(opt[i - 1][j - w[i - 1]] + w[i - 1], opt[i][j]);
                }
            }
        }


        return opt[w.length][W];
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream is = new FileInputStream(new File("6_1_knapsack.in"));
        System.setIn(is);
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}


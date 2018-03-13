import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments {

    private static int[] fastCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        Arrays.sort(starts);
        Arrays.sort(ends);
        for (int i = 0; i < points.length; i++) {
            int si = 0, ei = 0;

            while (si < starts.length && starts[si] <= points[i]) si++;

            while (ei < ends.length && ends[ei] < points[i]) ei++;

            cnt[i] = si - ei;
        }

        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream is = new FileInputStream(new File("4_5_lottery.in"));
        System.setIn(is);
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        int[][] segs = new int[n][2];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(starts, ends, points);
        //int[] cnt = naiveCountSegments(starts, ends, points);
        int res = 0;
        for (int x : cnt) {
            //System.out.print(x + " ");
            res += x;
        }
        System.out.println(res);
    }
}


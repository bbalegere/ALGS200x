import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Closest {

    static BufferedReader reader;
    static PrintWriter writer;
    static StringTokenizer tok = new StringTokenizer("");

    static double dist(Point x, Point y) {
        return Math.sqrt(Math.pow(x.x - y.x, 2) + Math.pow(x.y - y.y, 2));
    }

    static double minDistNaive(Point[] points, int left, int right) {
        if (left == right) return 0.0;

        double res = Double.POSITIVE_INFINITY;
        for (int i = left; i < right; i++) {
            for (int j = i + 1; j <= right; j++) {
                res = Math.min(res, dist(points[i], points[j]));
            }
        }
        return res;
    }

    static double minimalDistance(Point[] points, int left, int right) {
        int size = right - left + 1;
        if (size <= 3) {
            return minDistNaive(points, left, right);
        }

        Arrays.sort(points, Point.xsort);

        int mid = left + size / 2;
        double dl = minimalDistance(points, left, mid - 1);
        double dr = minimalDistance(points, mid, right);
        double d = Math.min(dl, dr);

        if (d == 0.0) return d;

        double median = ((double) points[mid - 1].x + (double) points[mid].x) / 2;
        ArrayList<Point> strip = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (Math.abs(points[i].x - median) <= d) {
                strip.add(points[i]);
            }
        }
        strip.sort(Point.ysort);

        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && ((strip.get(j).y - strip.get(i).y) < d); j++) {
                d = Math.min(d, dist(strip.get(i), strip.get(j)));
            }

        }
        return d;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream is = new FileInputStream(new File("4_6_closest.in"));
        System.setIn(is);
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(System.out);
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        Point[] pts = new Point[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
            pts[i] = new Point(x[i], y[i]);
        }
        System.out.println(minimalDistance(pts, 0, n - 1));
        writer.close();
    }

    static String next() {
        while (!tok.hasMoreTokens()) {
            String w = null;
            try {
                w = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (w == null)
                return null;
            tok = new StringTokenizer(w);
        }
        return tok.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }

    public static class Point {
        static Comparator<Point> xsort = (X, Y) -> X.x > Y.x ? 1 : -1;
        static Comparator<Point> ysort = (X, Y) -> X.y > Y.y ? 1 : -1;
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}

import java.io.*;
import java.util.StringTokenizer;

public class BinarySearch {

    static int binarySearch(int[] a, int x) {
        int left = 0, right = a.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (a[mid] == x) {
                return mid;
            } else if (x > a[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream is = new FileInputStream(new File("4_1_binary_search.in"));
        System.setIn(is);
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            if (binarySearch(a, b[i]) >= 0) result++;
        }

        System.out.print(result);
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

import java.io.*;
import java.util.StringTokenizer;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        int size = right - left + 1;
        if (size <= 2) {
            return a[left] == a[right] ? a[left] : Integer.MIN_VALUE;
        }

        int mid = left + size / 2;
        int lhs = getMajorityElement(a, left, mid);
        int rhs = getMajorityElement(a, mid + 1, right);

        if (lhs == Integer.MIN_VALUE || rhs == Integer.MIN_VALUE) {
            if (lhs != Integer.MIN_VALUE) {
                return lhs;
            } else return rhs;
        }

        if (lhs == rhs) return lhs;

        for (int can : new int[]{lhs, rhs}) {
            int count = 0;
            for (int i = left; i <= right; i++) {
                if (a[i] == can) {
                    count++;
                    if (count > size / 2) return can;
                }
            }

        }
        return Integer.MIN_VALUE;
    }

    static int bm_maj(int[] data) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int d : data) {
            if (count == 0) {
                result = d;
                count = 1;
            } else if (d == result) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int d : data) {
            if (d == result) {
                count++;
                if (count > data.length / 2) return result;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream is = new FileInputStream(new File("4_2_majority_element.in"));
        System.setIn(is);
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println(bm_maj(a));
        System.out.println(getMajorityElement(a, 0, a.length - 1));

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


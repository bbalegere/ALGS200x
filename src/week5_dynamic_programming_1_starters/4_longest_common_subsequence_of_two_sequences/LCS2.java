import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {

        int[][] mat = new int[a.length + 1][b.length + 1];

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {

                if (a[i - 1] == b[j - 1]) {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                } else {
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }

            }
        }
        //Write your code here
        return mat[a.length][b.length];
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream is = new FileInputStream(new File("5_4_lcs2.in"));
        System.setIn(is);
        Scanner scanner = new Scanner(System.in);
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

        System.out.println(lcs2(a, b));
    }
}


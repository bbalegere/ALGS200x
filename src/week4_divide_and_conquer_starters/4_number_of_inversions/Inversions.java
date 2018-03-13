import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Inversions {

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream is = new FileInputStream(new File("4_4_inversions.in"));
        System.setIn(is);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println(sort(a, 0, a.length - 1));
    }

    static long merge(int arr[], int l, int m, int r) {
        long numberOfInversions = 0;
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = Arrays.copyOfRange(arr, l, m + 1);
        int R[] = Arrays.copyOfRange(arr, m + 1, r + 1);

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                numberOfInversions += n1 - i;
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

        return numberOfInversions;
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static long sort(int arr[], int l, int r) {
        long numberOfInversions = 0;
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            numberOfInversions += sort(arr, l, m);
            numberOfInversions += sort(arr, m + 1, r);

            // Merge the sorted halves
            numberOfInversions += merge(arr, l, m, r);

        }
        return numberOfInversions;
    }
}


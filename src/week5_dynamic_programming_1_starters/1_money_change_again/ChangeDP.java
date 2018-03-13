import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        int[] mchange = new int[m + 1];
        int[] denoms = {1, 3, 4};
        mchange[0] = 0;
        for (int i = 1; i <= m; i++) {
            mchange[i] = Integer.MAX_VALUE;
            for (int d : denoms) {
                if (i >= d) {
                    mchange[i] = Math.min(mchange[i], mchange[i - d] + 1);
                }
            }
        }
        return mchange[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}


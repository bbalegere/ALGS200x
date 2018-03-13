import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class EditDistance {
    public static int EditDistance(String s, String t) {
        int[][] editm = new int[s.length() + 1][t.length() + 1];

        for (int i = 0; i < editm.length; i++) editm[i][0] = i;

        for (int i = 0; i < editm[0].length; i++) editm[0][i] = i;

        for (int i = 1; i < editm.length; i++) {

            for (int j = 1; j < editm[0].length; j++) {
                int daig = s.charAt(i - 1) == t.charAt(j - 1) ? 0 : 1;
                editm[i][j] = Collections.min(Arrays.asList(editm[i - 1][j - 1] + daig, editm[i][j - 1] + 1, editm[i - 1][j] + 1));

            }
        }
        return editm[s.length()][t.length()];
    }

    public static void main(String args[]) throws FileNotFoundException {
        FileInputStream is = new FileInputStream(new File("5_3_edit_distance.in"));
        System.setIn(is);
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(EditDistance(s, t));
    }

}
